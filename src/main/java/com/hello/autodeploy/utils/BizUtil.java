package com.hello.autodeploy.utils;

import com.hello.autodeploy.constant.Const;
import com.hello.autodeploy.core.ConfParser;
import com.hello.autodeploy.entity.Platform;

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

    private static Platform code2Platform(String code){
        Platform platform;
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
    private static List<String> getPlatformCodeList(){
        String codes = ConfParser.getRequiredString(Const.PLATFORM_CODE_LIST);
        List<String> codeList = Arrays.asList(codes.split(","));
        return codeList;
    }

    private static List<String> getChildrenServiceCodeList(String parentCode){
        String codes = ConfParser.getRequiredString(String.format(Const.TEMPLATE_PLATFORM_SERVICE_CODE_LIST, parentCode));
        List<String> codeList = Arrays.asList(codes.split(","));
        return codeList;
    }

    /**
     * 服务包路径
     * @return
     */
    private static String getServiceDeployPackage(){
        String deployPackage = null;
        return deployPackage;
    }

    /**
     * 配置文件路径
     * @return
     */
    private static String getServiceConf(){
        String deployPackage = null;
        return deployPackage;
    }

    /**
     * 启动脚本路径
     * @return
     */
    private static String getServiceStartBinPath(){
        String deployPackage = null;
        return deployPackage;
    }

    /**
     * 启动脚本输入参数
     * @return
     */
    private static String getServiceStartBinParams(){
        String deployPackage = null;
        return deployPackage;
    }

    /**
     * 服务停止脚本路径
     * @return
     */
    private static String getServiceStopBinPath(){
        String deployPackage = null;
        return deployPackage;
    }

    /**
     * 服务停止脚本输入参数
     * @return
     */
    private static String getServiceStopBinParams(){
        String deployPackage = null;
        return deployPackage;
    }
}
