package com.netflix.fabricator.component;

import java.util.Map;

import com.netflix.fabricator.ConfigurationSource;
import com.netflix.fabricator.PropertyInfo;
import com.netflix.fabricator.component.exception.ComponentAlreadyExistsException;
import com.netflix.fabricator.component.exception.ComponentCreationException;


/**
 * Factory for a specific component type.
 * 
 * @author elandau
 *
 * @param <T>
 */
public interface ComponentFactory<T> {
    /**
     * Create an instance of the component using the provided mapper
     * @param mapper
     * @return
     * @throws ComponentCreationException 
     * @throws ComponentAlreadyExistsException
     */
    T create(ConfigurationSource mapper) throws ComponentAlreadyExistsException, ComponentCreationException;
    
    /**
     * Return configuration properties of T
     * @return
     */
    Map<String, PropertyInfo> getProperties();
    
    /**
     * Return the actual type of T
     * @return
     */
    Class<?> getRawType();
}
