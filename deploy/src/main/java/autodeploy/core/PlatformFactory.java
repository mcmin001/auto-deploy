package autodeploy.core;


import autodeploy.entity.Host;
import autodeploy.entity.Platform;
import autodeploy.entity.Service;
import autodeploy.utils.BizUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 平台(服务)工厂类
 */
public class PlatformFactory {
    public static Platform createPlatform(String platformCode){
        Platform platform = new Platform(platformCode);

        List<Service> serviceList = new ArrayList<>();

        List<String> platFormServiceCodes = BizUtil.getPlatformServiceCodeList(platformCode);

        if(null == platFormServiceCodes || platFormServiceCodes.size() == 0){
            return platform;
        }

        for(String serviceCode : platFormServiceCodes){
            Service service = new Service();
            service.setServiceName(serviceCode);
            List<Host> hostList = BizUtil.getPlatformServiceHosts(platformCode, serviceCode);
            for(Host host : hostList){
                host.setServicePackageDeployPath(BizUtil.getServiceDeployPackage(platformCode, serviceCode));
                host.setServiceStartScriptPath(BizUtil.getServiceStartBinPath(platformCode, serviceCode));
                host.setServiceStartScriptParams(BizUtil.getServiceStartBinParams(platformCode, serviceCode));
                host.setServiceStopScriptPath(BizUtil.getServiceStopBinPath(platformCode, serviceCode));
                host.setServiceStopScriptParams(BizUtil.getServiceStopBinParams(platformCode, serviceCode));
                host.initSSHCommandExecutor();
            }
            service.setServiceHosts(hostList);
            serviceList.add(service);
        }

        platform.setServiceList(serviceList);
        return platform;
    }
}
