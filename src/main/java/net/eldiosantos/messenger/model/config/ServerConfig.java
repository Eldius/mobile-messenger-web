package net.eldiosantos.messenger.model.config;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Eldius on 07/03/2015.
 */
@Entity
public class ServerConfig {

    @Id
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getBooleanValue() {
        return Boolean.valueOf(getValue());
    }

    public Integer getIntegerValue() {
        return getValue()!=null?Integer.valueOf(getValue()):null;
    }

    public Long getLongValue() {
        return getValue()!=null?Long.valueOf(getValue()):null;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
