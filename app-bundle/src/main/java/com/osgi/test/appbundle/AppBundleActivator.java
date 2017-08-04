package com.osgi.test.appbundle;

import java.util.Collection;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.osgi.test.apibundle.api.ApiBundleInterface;

public class AppBundleActivator implements BundleActivator
{
    @Override
    public void start(BundleContext context) throws Exception
    {
        Collection<ServiceReference<ApiBundleInterface>> references = 
                context.getServiceReferences(ApiBundleInterface.class, "(serviceType=anotherOne)");
        
        System.out.println("References to Services: " + references); 
        
        refToService = references.iterator().next();
        
        ApiBundleInterface service = context.getService(refToService);
        service.doSomething();
        
        System.out.println("AppBundle started!");
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
        context.ungetService(refToService);
        
        System.out.println("AppBundle stopped!");
    }
    
    private ServiceReference<ApiBundleInterface> refToService;
}
