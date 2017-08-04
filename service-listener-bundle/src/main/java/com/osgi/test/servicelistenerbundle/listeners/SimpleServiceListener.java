package com.osgi.test.servicelistenerbundle.listeners;

import java.text.MessageFormat;
import java.util.Map;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class SimpleServiceListener implements ServiceListener
{
    @Override
    public void serviceChanged(ServiceEvent event)
    {
        logServiceChangeEvent(event);
    }
    
    private void logServiceChangeEvent(ServiceEvent event)
    {
        ServiceReference<?> refToService = event.getServiceReference();        
        String[] objectClass = (String[])refToService.getProperty("objectClass");
        System.out.println(MessageFormat.format(SERVICE_EVENT_MSG_FORMAT, 
            objectClass[0], 
            EVENT_TYPE_ID_TO_STR.get(event.getType()), 
            refToService.getBundle().getSymbolicName(),
            getServiceProperties(refToService)
        ));
    }
    
    private Map<String, Object> getServiceProperties(ServiceReference<?> refToService)
    {
        Map<String, Object> props = Maps.newHashMap();
        for (String propertyName : refToService.getPropertyKeys())
        {
            props.put(propertyName, refToService.getProperty(propertyName));
        }
        return props;
    }
    
    private static final Map<Integer, String> EVENT_TYPE_ID_TO_STR = 
        ImmutableMap.<Integer, String>builder()
            .put(ServiceEvent.MODIFIED, "modified")
            .put(ServiceEvent.REGISTERED, "registered")
            .put(ServiceEvent.UNREGISTERING, "unregistered")
        .build();
    
    private static final String SERVICE_EVENT_MSG_FORMAT = "Service of type \"{0}\" {1} by bundle \"{2}\".\nService properties: {3}";
}
