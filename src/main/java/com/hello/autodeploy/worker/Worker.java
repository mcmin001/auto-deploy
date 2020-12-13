package com.hello.autodeploy.worker;

import com.alibaba.fastjson.JSON;
import com.hello.autodeploy.core.PlatformFactory;
import com.hello.autodeploy.entity.Platform;

import java.util.List;

public class Worker {
    private List<String> platformCodes;

    public Worker (List<String> platformCodes){
        this.platformCodes = platformCodes;
    }

    public void startDeploy(){
        for(String platformCode : platformCodes){
            Platform platform = PlatformFactory.createPlatform(platformCode);
            System.out.println(JSON.toJSONString(platform));
        }
    }

    public List<String> getPlatformCodes() {
        return platformCodes;
    }

    public void setPlatformCodes(List<String> platformCodes) {
        this.platformCodes = platformCodes;
    }
}
