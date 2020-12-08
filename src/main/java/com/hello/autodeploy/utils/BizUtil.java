package com.hello.autodeploy.utils;

import com.hello.autodeploy.constant.Const;
import com.hello.autodeploy.entity.Platform;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

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
}
