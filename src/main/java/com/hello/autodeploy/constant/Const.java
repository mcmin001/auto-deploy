package com.hello.autodeploy.constant;

public class Const {
    /**
     * IDGP
     */
    public static final String IDGP_CODE = "1";
    /**
     * AQPT
     */
    public static final String AQPT_CODE = "2";

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
     * 指定平台(服务)指定子服务的配置文件
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_SERVICE = "%s.platform.service.%s.conf";

    /**
     * 指定平台(服务)指定子服务的部署包
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_PACKAGE = "%s.platform.service.%s.package";

    /**
     * 指定平台(服务)指定子服务的启动脚本路径
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_BIN_START = "%s.platform.service.%s.bin.start";

    /**
     * 指定平台(服务)指定子服务的启动脚本输入参数
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_BIN_START_PARAMS = "%s.platform.service.%s.bin.start.params";

    /**
     * 指定平台(服务)指定子服务的停止脚本路径
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_BIN_STOP = "%s.platform.service.%s.bin.stop";

    /**
     * 指定平台(服务)指定子服务的停止脚本输入参数
     */
    public static final String TEMPLATE_PLATFORM_SERVICE_CODE_BIN_STOP_PARAMS = "%s.platform.service.%s.bin.stop.params";
}
