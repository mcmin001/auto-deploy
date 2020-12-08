package com.hello.autodeploy.entity;

public class Host {
    private String ip;
    private int port;
    private String sshUserName;
    private int sshPort;
    private String servicePackageDeployPath;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getSshUserName() {
        return sshUserName;
    }

    public void setSshUserName(String sshUserName) {
        this.sshUserName = sshUserName;
    }

    public int getSshPort() {
        return sshPort;
    }

    public void setSshPort(int sshPort) {
        this.sshPort = sshPort;
    }

    public String getServicePackageDeployPath() {
        return servicePackageDeployPath;
    }

    public void setServicePackageDeployPath(String servicePackageDeployPath) {
        this.servicePackageDeployPath = servicePackageDeployPath;
    }
}
