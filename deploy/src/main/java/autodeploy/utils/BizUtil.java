package autodeploy.utils;


import autodeploy.constant.Const;
import autodeploy.core.ConfParser;
import autodeploy.entity.Platform;

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

        switch (code){
            case Const.IDGP_CODE:
                platform = new Platform(code);
                break;
            case Const.AQPT_CODE:
                platform = new Platform(code);
                break;
            default:
                throw new IllegalArgumentException("暂且不支持部署该服务，服务编码:" + code);
        }
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

    public static List<String> getPlatformServiceHosts(String platform, String serviceCode){
        String hosts = ConfParser.getRequiredString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_HOSTS, platform, serviceCode));
        List<String> hostList = Arrays.asList(hosts.split(","));
        return hostList;
    }

    /**
     * 服务包路径
     * @return
     */
    public static String getServiceDeployPackage(String platform, String serviceCode){
        String deployPackage = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_PACKAGE, platform, serviceCode));
        return deployPackage;
    }

    /**
     * 配置文件路径
     * @return
     */
    public static String getServiceConf(String platform, String serviceCode){
        String serviceConf = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_SERVICE, platform, serviceCode));
        return serviceConf;
    }

    /**
     * 启动脚本路径
     * @return
     */
    public static String getServiceStartBinPath(String platform, String serviceCode){
        String startBinPath = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_BIN_START, platform, serviceCode));
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
     * 服务停止脚本路径
     * @return
     */
    public static String getServiceStopBinPath(String platform, String serviceCode){
        String stopBinPath = ConfParser.getString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_BIN_STOP, platform, serviceCode));
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
