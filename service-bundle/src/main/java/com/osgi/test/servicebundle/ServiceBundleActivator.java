package com.osgi.test.servicebundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.osgi.test.apibundle.api.ApiBundleInterface;
import com.osgi.test.servicebundle.services.ApiBundleInterfaceImplementation;

public class ServiceBundleActivator implements BundleActivator
{   
    @Override
    public void start(BundleContext context) throws Exception
    {
        ApiBundleInterface service = new ApiBundleInterfaceImplementation(); 
        registeredService = context.registerService(ApiBundleInterface.class, service, null);                
        
        System.out.println("ServiceBundle started!");
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
        registeredService.unregister();
        
        System.out.println("ServiceBundle stopped!");
    }
    
    private ServiceRegistration<ApiBundleInterface> registeredService;
}
