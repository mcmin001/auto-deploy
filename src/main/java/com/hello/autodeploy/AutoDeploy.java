package com.hello.autodeploy;

import com.hello.autodeploy.utils.ConsoleScannerUtil;

public class AutoDeploy {
    public static void main(String[] args) {
        System.out.println("*************************************");
        System.out.println("*************************************");
        System.out.println("***** auto deploy start now ... *****");
        System.out.println("please choose services to deploy, enter the number what you choose. use \";\" to split");
        System.out.println("IDGP 数据治理平台:1");
        System.out.println("AQPT 数据安全平台:2");

        System.out.print("input:");

        String chooses = ConsoleScannerUtil.getConsoleInput();
        System.out.println(chooses);
    }
}
