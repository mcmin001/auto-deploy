package autodeploy.entity;

import java.util.List;

public class Platform {
    /**
     * 平台(服务)编码
     */
    private String platformCode;
    /**
     * 平台(服务)名称
     */
    private String platformName;
    /**
     * 平台(服务)子服务集合
     */
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
