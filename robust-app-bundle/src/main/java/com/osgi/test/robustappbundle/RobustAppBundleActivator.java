package com.osgi.test.robustappbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.osgi.test.apibundle.api.ApiBundleInterface;

public class RobustAppBundleActivator implements BundleActivator
{
    @Override
    public void start(BundleContext context) throws Exception
    {
        serviceTracker = new ServiceTracker<>(context, ApiBundleInterface.class, null);
        serviceTracker.open();
        
        ApiBundleInterface service = serviceTracker.getService();
        service.doSomething();
        
        System.out.println("RobustAppBundle started!");
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
        System.out.println("RobustAppBundle stopped!");
    }
    
    private ServiceTracker<ApiBundleInterface, ApiBundleInterface> serviceTracker;
}
