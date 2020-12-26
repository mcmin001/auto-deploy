package autodeploy.entity;

import com.google.common.base.Preconditions;
import com.mcmin.utils.ssh.SSHCommandExecutor;

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
     * ssh连接用户名
     */
    private String sshPassword;
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
     * 服务启动脚本输入参数
     */
    private String serviceStartScriptParams;
    /**
     * 主机服务停止脚本路径
     */
    private String serviceStopScriptPath;
    /**
     * 服务停止脚本输入参数
     */
    private String serviceStopScriptParams;
    /**
     * ssh 命令执行器
     */
    private SSHCommandExecutor sshCommandExecutor;


    public void initSSHCommandExecutor(){
        checkRequiredParams();
        sshCommandExecutor = new SSHCommandExecutor(ip, sshPort, sshUserName, sshPassword);
    }

    private void checkRequiredParams(){
        Preconditions.checkNotNull(ip);
        Preconditions.checkNotNull(port);
        Preconditions.checkNotNull(sshUserName);
        Preconditions.checkNotNull(sshPassword);
        Preconditions.checkNotNull(sshPort);
    }

    public SSHCommandExecutor getSshCommandExecutor() {
        Preconditions.checkNotNull(sshCommandExecutor);
        return sshCommandExecutor;
    }

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

    public String getServiceStartScriptParams() {
        return serviceStartScriptParams;
    }

    public void setServiceStartScriptParams(String serviceStartScriptParams) {
        this.serviceStartScriptParams = serviceStartScriptParams;
    }

    public String getServiceStopScriptParams() {
        return serviceStopScriptParams;
    }

    public void setServiceStopScriptParams(String serviceStopScriptParams) {
        this.serviceStopScriptParams = serviceStopScriptParams;
    }

    public String getSshPassword() {
        return sshPassword;
    }

    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
    }
}
