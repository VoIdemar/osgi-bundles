package com.osgi.test.servicebundle;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.osgi.test.apibundle.api.ApiBundleInterface;
import com.osgi.test.servicebundle.services.AnotherApiBundleInterfaceImplementation;
import com.osgi.test.servicebundle.services.ApiBundleInterfaceImplementation;

public class ServiceBundleActivator implements BundleActivator
{   
    @Override
    public void start(BundleContext context) throws Exception
    {
        ApiBundleInterface service = new ApiBundleInterfaceImplementation();
        Hashtable<String, String> serviceProps = new Hashtable<>();
        serviceProps.put("serviceType", "default");
        registeredService = context.registerService(ApiBundleInterface.class, service, serviceProps);
        
        ApiBundleInterface anotherService = new AnotherApiBundleInterfaceImplementation();
        Hashtable<String, String> anotherServiceProps = new Hashtable<>();
        anotherServiceProps.put("serviceType", "anotherOne");
        anotherRegisteredService = context.registerService(
                ApiBundleInterface.class, anotherService, anotherServiceProps);
        
        System.out.println("ServiceBundle started!");
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
        registeredService.unregister();
        anotherRegisteredService.unregister();
        
        System.out.println("ServiceBundle stopped!");
    }
    
    private ServiceRegistration<ApiBundleInterface> registeredService;
    private ServiceRegistration<ApiBundleInterface> anotherRegisteredService;
}
