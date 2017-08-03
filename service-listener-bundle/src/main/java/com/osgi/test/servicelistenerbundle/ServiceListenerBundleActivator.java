package com.osgi.test.servicelistenerbundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;

import com.osgi.test.servicelistenerbundle.listeners.SimpleServiceListener;

public class ServiceListenerBundleActivator implements BundleActivator
{
    @Override
    public void start(BundleContext context) throws Exception
    {
        serviceListener = new SimpleServiceListener();
        context.addServiceListener(serviceListener);
        
        System.out.println("ServiceListenerBundle started!");
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
        context.removeServiceListener(serviceListener);
        
        System.out.println("ServiceListenerBundle stopped!");
    }
    
    private ServiceListener serviceListener;
}
