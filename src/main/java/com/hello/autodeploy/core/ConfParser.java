package com.hello.autodeploy.core;

import java.io.*;
import java.util.Properties;

public class ConfParser {
    private Properties confProperties;

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

    public String getPlatform
}
