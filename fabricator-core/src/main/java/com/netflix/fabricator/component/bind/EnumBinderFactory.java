package com.netflix.fabricator.component.bind;

import java.lang.reflect.Method;

import com.netflix.fabricator.ConfigurationSource;
import com.netflix.fabricator.PropertyBinder;
import com.netflix.fabricator.PropertyBinderFactory;

public class EnumBinderFactory implements PropertyBinderFactory {
    private final static EnumBinderFactory instance = new EnumBinderFactory();
    
    public static EnumBinderFactory get() {
        return instance;
    }

    @Override
    public PropertyBinder createBinder(final Method method, final String propertyName) {
        final Class<?>[] types = method.getParameterTypes();
        final Class<?> clazz = types[0];
        if (!clazz.isEnum()) {
            return null;
        }
        
        return new PropertyBinder() {
                @Override
                public boolean bind(Object obj, ConfigurationSource mapper) throws Exception {
                    String value = mapper.getValue(propertyName, String.class);
                    if (value != null) {
                        method.invoke(obj, Enum.valueOf((Class<Enum>)method.getParameterTypes()[0], value));
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            };    
    }
}
