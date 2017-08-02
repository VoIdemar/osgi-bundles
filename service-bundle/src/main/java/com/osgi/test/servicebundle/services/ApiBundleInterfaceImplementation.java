package com.osgi.test.servicebundle.services;

import com.osgi.test.apibundle.api.ApiBundleInterface;

public class ApiBundleInterfaceImplementation implements ApiBundleInterface 
{
    @Override
    public void doSomething()
    {
        System.out.println("ApiBundleInterfaceImplementation does something!!!");
    }
}
