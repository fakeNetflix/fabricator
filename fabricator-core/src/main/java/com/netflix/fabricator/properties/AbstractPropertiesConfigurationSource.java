package com.netflix.fabricator.properties;

import com.netflix.fabricator.ConfigurationSource;

/**
 * Base source for 'properties' driven configuration where each 'child' 
 * is namespaced by a property prefix
 * 
 * @author elandau
 *
 */
public abstract class AbstractPropertiesConfigurationSource implements ConfigurationSource {
    private final String     id;
    private final String     type;
    private final String     prefix;
    
    public AbstractPropertiesConfigurationSource(String id, String type) {
        this.id    = id;
        this.type  = type;
        this.prefix = "";
    }
    
    public AbstractPropertiesConfigurationSource(String id, String type, String prefix) {
        this.id     = id;
        this.type   = type;
        if (prefix.endsWith(".")) {
            this.prefix = prefix;
        }
        else {
            this.prefix = prefix + ".";
        }
    }
    
    @Override
    public String getKey() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
}
