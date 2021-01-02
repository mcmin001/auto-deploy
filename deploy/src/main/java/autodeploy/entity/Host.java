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
     * 主机服务部署路径-源地址
     */
    private String serviceRepositoryPackagePath;
    /**
     * 主机服务部署路径-目的地地址
     */
    private String serviceDeployPackagePath;

    /**
     * 服务配置文件-源地址
     */
    private String serviceRepositoryConfPath;
    /**
     * 服务配置文件-目的地地址
     */
    private String serviceDeployConfPath;

    /**
     * 主机服务启动脚本路径-源地址
     */
    private String serviceRepositoryStartScriptPath;
    /**
     * 主机服务启动脚本路径-目的地地址
     */
    private String serviceDeployStartScriptPath;
    /**
     * 服务启动脚本输入参数
     */
    private String serviceStartScriptParams;
    /**
     * 主机服务停止脚本路径-源地址
     */
    private String serviceRepositoryStopScriptPath;
    /**
     * 主机服务停止脚本路径-目的地地址
     */
    private String serviceDeployStopScriptPath;
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
        Preconditions.checkNotNull(ip, "Host ip is null");
        Preconditions.checkNotNull(port);
        Preconditions.checkNotNull(sshUserName, "Host sshUserName is null");
        Preconditions.checkNotNull(sshPassword, "Host sshPassword is null");
        Preconditions.checkNotNull(sshPort);
    }

    public SSHCommandExecutor getSshCommandExecutor() {
        Preconditions.checkNotNull(sshCommandExecutor, "Host SSHCommandExecutor is null");
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

    public String getServiceRepositoryPackagePath() {
        return serviceRepositoryPackagePath;
    }

    public void setServiceRepositoryPackagePath(String serviceRepositoryPackagePath) {
        this.serviceRepositoryPackagePath = serviceRepositoryPackagePath;
    }

    public String getServiceDeployPackagePath() {
        return serviceDeployPackagePath;
    }

    public void setServiceDeployPackagePath(String serviceDeployPackagePath) {
        this.serviceDeployPackagePath = serviceDeployPackagePath;
    }

    public String getServiceRepositoryStartScriptPath() {
        return serviceRepositoryStartScriptPath;
    }

    public void setServiceRepositoryStartScriptPath(String serviceRepositoryStartScriptPath) {
        this.serviceRepositoryStartScriptPath = serviceRepositoryStartScriptPath;
    }

    public String getServiceDeployStartScriptPath() {
        return serviceDeployStartScriptPath;
    }

    public void setServiceDeployStartScriptPath(String serviceDeployStartScriptPath) {
        this.serviceDeployStartScriptPath = serviceDeployStartScriptPath;
    }

    public String getServiceRepositoryStopScriptPath() {
        return serviceRepositoryStopScriptPath;
    }

    public void setServiceRepositoryStopScriptPath(String serviceRepositoryStopScriptPath) {
        this.serviceRepositoryStopScriptPath = serviceRepositoryStopScriptPath;
    }

    public String getServiceDeployStopScriptPath() {
        return serviceDeployStopScriptPath;
    }

    public void setServiceDeployStopScriptPath(String serviceDeployStopScriptPath) {
        this.serviceDeployStopScriptPath = serviceDeployStopScriptPath;
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

    public String getServiceRepositoryConfPath() {
        return serviceRepositoryConfPath;
    }

    public void setServiceRepositoryConfPath(String serviceRepositoryConfPath) {
        this.serviceRepositoryConfPath = serviceRepositoryConfPath;
    }

    public String getServiceDeployConfPath() {
        return serviceDeployConfPath;
    }

    public void setServiceDeployConfPath(String serviceDeployConfPath) {
        this.serviceDeployConfPath = serviceDeployConfPath;
    }

    public String getSshPassword() {
        return sshPassword;
    }

    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
    }
}
