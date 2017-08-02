package com.osgi.test.appbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.osgi.test.apibundle.api.ApiBundleInterface;

public class AppBundleActivator implements BundleActivator
{
    @Override
    public void start(BundleContext context) throws Exception
    {
        refToService = context.getServiceReference(ApiBundleInterface.class);
        
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
