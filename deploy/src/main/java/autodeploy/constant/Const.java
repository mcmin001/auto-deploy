package autodeploy.constant;

public class Const {

    public static final String TEMPLATE_CONSOLE_CHOOSE_PLATFORM_CODE = "%s->platform code is:%s";

    public static final String TEMPLATE_CONFORM_DEPLOY_PLATFORM_CODE = "%s will be deploied";

    /**
     * 平台(服务)编码集合key
     */
    public static final String PLATFORM_CODE_LIST = "platform.code.list";

    /**
     * 平台(服务)配置文件key
     */
    public static final String TEMPLATE_PLATFORM_CONF = "%s.platform.conf";

    /**
     * 平台(服务)部署包key
     */
    public static final String TEMPLATE_PLATFORM_PACKAGE = "%s.platform.package";

    /**
     * 指定平台(服务)子服务编码集合key
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_LIST = "%s.platform.service.code.list";

    /**
     * 指定平台(服务)子服务部署机器IP
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_HOSTS = "%s.platform.service.%s.hosts";

    /**
     * 指定平台(服务)指定子 服务的配置文件-源地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_CONF = "%s.platform.service.%s.repository.conf";

    /**
     * 指定平台(服务)指定子 服务的配置文件-目的地地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_CONF = "%s.platform.service.%s.deploy.conf";

    /**
     * 指定平台(服务)指定子 服务的部署包-源地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_PACKAGE = "%s.platform.service.%s.repository.package";
    /**
     * 指定平台(服务)指定子 服务的部署包-目的地地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_PACKAGE = "%s.platform.service.%s.deploy.package";

    /**
     * 指定平台(服务)指定子服务的启动脚本路径-源地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_BIN_START = "%s.platform.service.%s.repository.bin.start";
    /**
     * 指定平台(服务)指定子服务的启动脚本路径-目的地地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_BIN_START = "%s.platform.service.%s.deploy.bin.start";

    /**
     * 指定平台(服务)指定子服务的启动脚本输入参数
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_BIN_START_PARAMS = "%s.platform.service.%s.bin.start.params";

    /**
     * 指定平台(服务)指定子服务的 停止脚本路径-源地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_REPOSITORY_BIN_STOP = "%s.platform.service.%s.repository.bin.stop";
    /**
     * 指定平台(服务)指定子服务的 停止脚本路径-目的地地址
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_DEPLOY_BIN_STOP = "%s.platform.service.%s.deploy.bin.stop";

    /**
     * 指定平台(服务)指定子服务的 停止脚本输入参数
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_BIN_STOP_PARAMS = "%s.platform.service.%s.bin.stop.params";
}
