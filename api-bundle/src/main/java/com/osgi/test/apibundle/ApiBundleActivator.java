package com.osgi.test.apibundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ApiBundleActivator implements BundleActivator
{
    @Override
    public void start(BundleContext context) throws Exception
    {
        System.out.println("ApiBundle started!");
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
        System.out.println("ApiBundle stopped!");
    }
}
