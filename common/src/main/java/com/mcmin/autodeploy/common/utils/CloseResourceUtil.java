package com.mcmin.autodeploy.common.utils;

import java.io.Closeable;
import java.io.IOException;

public class CloseResourceUtil {
    public static void close(Closeable ...closeables){
        for(Closeable resource : closeables){
            if(null != resource){
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
