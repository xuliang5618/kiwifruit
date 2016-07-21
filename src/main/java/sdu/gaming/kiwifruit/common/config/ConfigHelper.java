package sdu.gaming.kiwifruit.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by wanghao@weipass.cn on 2015/11/9.
 * 配置系统变量自动识别当前环境加载文件
 */
public class ConfigHelper {

    /**
     * config路径
     */
    private static final String CONFIG_PATH = "config/config.properties";


    private static Properties instance;

    static {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_PATH);
        if (is == null)
            throw new RuntimeException("没有找到config/config.properties");
        instance = new Properties();
        try {
            instance.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {

            }
        }
    }

    public static String getProperty(String key) {
        return instance.getProperty(key);
    }

    /**
     * properties转map
     *
     * @return
     */
    public static Map<String, String> propertiesToMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        Set<String> keys = instance.stringPropertyNames();
        for (String key : keys) {
            map.put(key, instance.getProperty(key));
        }
        return map;
    }

}
