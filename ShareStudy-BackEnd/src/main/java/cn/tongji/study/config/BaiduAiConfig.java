package cn.tongji.study.config;

import com.baidu.aip.contentcensor.AipContentCensor;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : 王晨
 * @Date : Created in 23:44 2022/11/15
 */
@Configuration
public class BaiduAiConfig {
    public static final String APP_ID ="28447011";

    public static final String API_KEY = "xc9f0AKyxA4eXBlV5c9ikFEy";

    public static final String SECRET_KEY = "GemGq3qmTQyNcKzwclSDknG2xdYwsbzB";

    /*初始化客户端*/
    public static final AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);
    public static AipContentCensor getClient() {
        // 初始化一个AipImageCensor


        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);

        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        return client;
    }
}
