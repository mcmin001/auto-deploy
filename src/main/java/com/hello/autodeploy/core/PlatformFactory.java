package com.hello.autodeploy.core;

import com.hello.autodeploy.entity.Host;
import com.hello.autodeploy.entity.Platform;
import com.hello.autodeploy.entity.Service;
import com.hello.autodeploy.utils.BizUtil;

import java.util.List;

public class PlatformFactory {
    public static Platform createPlatform(String platformCode){
        Platform platform = new Platform(platformCode);

        List<String> platFormServiceCodes = BizUtil.getPlatformServiceCodeList(platformCode);

        if(null == platFormServiceCodes || platFormServiceCodes.size() == 0){
            return platform;
        }

        for(String serviceCode : platFormServiceCodes){
            Service service = new Service();
            service.setServiceName(serviceCode);

            List<String> hosts = BizUtil.getPlatformServiceHosts(platformCode, serviceCode);
            for(String host : hosts){
                Host serviceHost = new Host();
                serviceHost.setIp(host);
                serviceHost.setServicePackageDeployPath(BizUtil.getServiceDeployPackage(platformCode, serviceCode));
                serviceHost.setServiceStartScriptPath(BizUtil.getServiceStartBinPath(platformCode, serviceCode));
            }
        }

        return platform;
    }
}
