package com.hello.autodeploy.entity;

public class Host {
    /**
     * 主机IP
     */
    private String ip;
    /**
     * 主机进程port
     */
    private int port;
    /**
     * ssh连接用户名
     */
    private String sshUserName;
    /**
     * ssh连接端口，默认22
     */
    private int sshPort;
    /**
     * 主机服务部署路径
     */
    private String servicePackageDeployPath;
    /**
     * 主机服务启动脚本路径
     */
    private String serviceStartScriptPath;
    /**
     * 主机服务停止脚本路径
     */
    private String serviceStopScriptPath;

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

    public String getServiceStartScriptPath() {
        return serviceStartScriptPath;
    }

    public void setServiceStartScriptPath(String serviceStartScriptPath) {
        this.serviceStartScriptPath = serviceStartScriptPath;
    }

    public String getServiceStopScriptPath() {
        return serviceStopScriptPath;
    }

    public void setServiceStopScriptPath(String serviceStopScriptPath) {
        this.serviceStopScriptPath = serviceStopScriptPath;
    }
}
