package autodeploy.utils;


import autodeploy.constant.Const;
import autodeploy.core.ConfParser;
import autodeploy.entity.Host;
import autodeploy.entity.Platform;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BizUtil {
    public static List<Platform> getChoosePlatforms(String chooses){
        List<Platform> platformList = new ArrayList<>();

        if(null == chooses || chooses.length() <= 0){
            throw new IllegalArgumentException("请至少选择一种服务进行部署");
        }

        List<String> chooseCodes = Arrays.asList(chooses.split(",").clone());

        for(String code : chooseCodes){
            platformList.add(code2Platform(code));
        }

        return platformList;
    }

    public static Platform code2Platform(String code){
        Platform platform = new Platform(code);
        return platform;
    }

    /**
     * 获取平台(服务编码)
     * @return
     */
    public static List<String> getPlatformCodeList(){
        String codes = ConfParser.getRequiredString(Const.PLATFORM_CODE_LIST);
        List<String> codeList = Arrays.asList(codes.split(","));
        return codeList;
    }

    public static List<String> getPlatformServiceCodeList(String parentCode){
        String codes = ConfParser.getRequiredString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_LIST, parentCode));
        List<String> codeList = Arrays.asList(codes.split(","));
        return codeList;
    }

    public static List<Host> getPlatformServiceHosts(String platform, String serviceCode){
        String hosts = ConfParser.getRequiredString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_HOSTS, platform, serviceCode));

        List<Host> hostList = JSON.parseArray(hosts, Host.class);

        return hostList;
    }

    /**
     * 服务部署包路径-源地址
     * @param platform
     * @param serviceCode
     * @return
     */
    public static String getServiceRepositoryPackagePath(String platform, String serviceCode){
        String repositoryPackagePath = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_PACKAGE, platform, serviceCode));
        return repositoryPackagePath;
    }

    /**
     * 服务部署包路径-目的地地址
     * @return
     */
    public static String getServiceDeployPackagePath(String platform, String serviceCode){
        String deployPackage = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_PACKAGE, platform, serviceCode));
        return deployPackage;
    }

    /**
     * 服务配置文件路径-源地址
     * @return
     */
    public static String getServiceRepositoryConfPath(String platform, String serviceCode){
        String serviceRepositoryConf = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_CONF, platform, serviceCode));
        return serviceRepositoryConf;
    }

    /**
     * 服务配置文件路径-目的地地址
     * @param platform
     * @param serviceCode
     * @return
     */
    public static String getServiceDeployConfPath(String platform, String serviceCode){
        String serviceDeployConf = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_CONF, platform, serviceCode));
        return serviceDeployConf;
    }

    /**
     * 服务启动脚本路径-源地址
     * @param platform
     * @param serviceCode
     * @return
     */
    public static String getServiceRepositoryStartScriptPath(String platform, String serviceCode){
        String repositoryStartBinPath = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_BIN_START, platform, serviceCode));
        return repositoryStartBinPath;
    }

    /**
     * 服务启动脚本路径-目的地地址
     * @return
     */
    public static String getServiceDeployStartScriptPath(String platform, String serviceCode){
        String startBinPath = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_BIN_START, platform, serviceCode));
        return startBinPath;
    }

    /**
     * 启动脚本输入参数
     * @return
     */
    public static String getServiceStartBinParams(String platform, String serviceCode){
        String startBinPathParams = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_BIN_START_PARAMS, platform, serviceCode));
        return startBinPathParams;
    }

    /**
     * 服务停止脚本路径-源地址
     * @param platform
     * @param serviceCode
     * @return
     */
    public static String getServiceRepositoryStopScriptPath(String platform, String serviceCode){
        String repositoryStopBinPath = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_BIN_STOP, platform, serviceCode));
        return repositoryStopBinPath;
    }

    /**
     * 服务停止脚本路径-目的地地址
     * @return
     */
    public static String getServiceDeployStopScriptPath(String platform, String serviceCode){
        String stopBinPath = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_BIN_STOP, platform, serviceCode));
        return stopBinPath;
    }

    /**
     * 服务停止脚本输入参数
     * @return
     */
    public static String getServiceStopBinParams(String platform, String serviceCode){
        String stopBinParams = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_BIN_STOP_PARAMS, platform, serviceCode));
        return stopBinParams;
    }
}
