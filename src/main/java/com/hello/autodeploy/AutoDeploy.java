package com.hello.autodeploy;

import com.hello.autodeploy.constant.Const;
import com.hello.autodeploy.core.ConfParser;
import com.hello.autodeploy.utils.ConsoleScannerUtil;
import com.hello.autodeploy.worker.Worker;

import java.util.Arrays;
import java.util.List;

public class AutoDeploy {
    public static void main(String[] args) {
        try{
            String confPath = args[0];

            ConfParser.init(confPath);

            List<String> platformCodes = ConfParser.getStringListOnSplit("platform.code.list", ",");


            System.out.println("*************************************");
            System.out.println("*************************************");
            System.out.println("***** auto deploy start now ... *****");
            System.out.println("please choose services to deploy, enter the code what you choose. use \",\" to split");

            int index = 1;
            for(String code : platformCodes){
                System.out.println(String.format(Const.TEMPLATE_CONSOLE_CHOOSE_PLATFORM_CODE, index, code));
            }
            System.out.print("please input:");

            String chooses = ConsoleScannerUtil.getConsoleInput();

            System.out.println(String.format(Const.TEMPLATE_CONFORM_DEPLOY_PLATFORM_CODE, chooses));

            Worker worker = new Worker(Arrays.asList(chooses.split(",")));

            worker.startDeploy();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
