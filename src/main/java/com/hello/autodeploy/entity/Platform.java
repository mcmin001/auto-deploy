package com.hello.autodeploy.entity;

import java.util.List;

public class Platform {
    private String platformCode;
    private String platformName;
    private List<Service> serviceList;

    public Platform(){}

    public Platform(String code){
        this.platformCode = code;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }
}
