package com.hello.autodeploy.core;

import java.io.*;
import java.util.Properties;

public class ConfParser {
    private static Properties confProperties;

    public ConfParser(){}

    public ConfParser build(String confPath) throws IOException {
        if(null == confPath || confPath.length() <=0){
            throw new IllegalArgumentException("confPath is blank");
        }
        FileInputStream fileInputStream = new FileInputStream(new File(confPath));

        confProperties = new Properties();
        confProperties.load(fileInputStream);

        return this;
    }

    public ConfParser build(InputStream confInputStream) throws IOException {
        if(null == confInputStream){
            throw new IllegalArgumentException("confInputStream is null");
        }
        confProperties = new Properties();
        confProperties.load(confInputStream);

        return this;
    }

    public static String getString(String key){
        return confProperties.getProperty(key);
    }

    public static String getRequiredString(String key){
        String value = confProperties.getProperty(key);
        if(null == value || value.length() <= 0){
            throw new IllegalArgumentException("not found required value , key=" + key);
        }
        return value;
    }

    public static String getStringOrDefault(String key, String defaultValue){
        String value = confProperties.getProperty(key);
        if(null == value || value.length() <= 0){
            return defaultValue;
        }
        return value;
    }

    public static Integer getIntegerOrDefault(String key, Integer defaultValue){
        Object value = confProperties.getProperty(key);
        if(null == value){
            return defaultValue;
        }
        return (Integer) value;
    }

}
