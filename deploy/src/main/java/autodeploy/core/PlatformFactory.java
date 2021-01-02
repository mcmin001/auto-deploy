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

                //set 服务部署包路径-源地址
                host.setServiceRepositoryPackagePath(BizUtil.getServiceRepositoryPackagePath(platformCode, serviceCode));
                //set 服务部署包路径-目的地地址
                host.setServiceDeployPackagePath(BizUtil.getServiceDeployPackagePath(platformCode, serviceCode));

                //set 服务配置文件路径-源地址
                host.setServiceRepositoryConfPath(BizUtil.getServiceRepositoryConfPath(platformCode, serviceCode));
                //set 服务配置文件路径-目的地地址
                host.setServiceDeployConfPath(BizUtil.getServiceDeployConfPath(platformCode, serviceCode));

                //set 服务启动脚本路径-源地址
                host.setServiceRepositoryStartScriptPath(BizUtil.getServiceRepositoryStartScriptPath(platformCode, serviceCode));
                //set 服务启动脚本路径-目的地地址
                host.setServiceDeployStartScriptPath(BizUtil.getServiceDeployStartScriptPath(platformCode, serviceCode));
                //set 服务启动脚本参数
                host.setServiceStartScriptParams(BizUtil.getServiceStartBinParams(platformCode, serviceCode));

                //set 服务停止脚本路径-源地址
                host.setServiceRepositoryStopScriptPath(BizUtil.getServiceRepositoryStopScriptPath(platformCode, serviceCode));
                //set 服务停止脚本路径-目的地地址
                host.setServiceDeployStopScriptPath(BizUtil.getServiceDeployStopScriptPath(platformCode, serviceCode));
                //set 服务停止脚本参数
                host.setServiceStopScriptParams(BizUtil.getServiceStopBinParams(platformCode, serviceCode));

                //set ssh操作类
                host.initSSHCommandExecutor();

            }
            service.setServiceHosts(hostList);
            serviceList.add(service);
        }

        platform.setServiceList(serviceList);
        return platform;
    }
}
