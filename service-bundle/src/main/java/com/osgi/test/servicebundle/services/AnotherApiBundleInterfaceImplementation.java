package com.osgi.test.servicebundle.services;

import com.osgi.test.apibundle.api.ApiBundleInterface;

public class AnotherApiBundleInterfaceImplementation implements ApiBundleInterface
{
    @Override
    public void doSomething()
    {
        System.out.println("AnotherApiBundleInterfaceImplementation does something!!!");
    }
}
