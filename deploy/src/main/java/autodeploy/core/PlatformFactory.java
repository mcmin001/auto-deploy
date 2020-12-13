package autodeploy.core;

import com.hello.autodeploy.entity.Host;
import com.hello.autodeploy.entity.Platform;
import com.hello.autodeploy.entity.Service;
import com.hello.autodeploy.utils.BizUtil;

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
            List<String> hosts = BizUtil.getPlatformServiceHosts(platformCode, serviceCode);
            List<Host> hostList = new ArrayList<>();
            for(String host : hosts){
                Host serviceHost = new Host();
                serviceHost.setIp(host);
                serviceHost.setServicePackageDeployPath(BizUtil.getServiceDeployPackage(platformCode, serviceCode));
                serviceHost.setServiceStartScriptPath(BizUtil.getServiceStartBinPath(platformCode, serviceCode));
                serviceHost.setServiceStartScriptParams(BizUtil.getServiceStartBinParams(platformCode, serviceCode));
                serviceHost.setServiceStopScriptPath(BizUtil.getServiceStopBinPath(platformCode, serviceCode));
                serviceHost.setServiceStopScriptParams(BizUtil.getServiceStopBinParams(platformCode, serviceCode));

                hostList.add(serviceHost);
            }
            service.setServiceHosts(hostList);
            serviceList.add(service);
        }

        platform.setServiceList(serviceList);
        return platform;
    }
}
