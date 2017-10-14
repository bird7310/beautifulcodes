package com.ahacool.code.java.mtsafe.ini;

/**
 * Description: lv3和JVM的延迟加载机制结合，形成了一种完备的延迟初始化技术-延迟初始化占位类模式。
 *              lv4
 *
 * @author: moto
 * @time: 17/10/14 上午9:40
 */

public class ResourceFactory {

    //静态初始化不需要额外的同步机制
    private static class ResourceHolder {
        public static Resource resource = new Resource();
    }

    //延迟加载
    public static Resource getResource() {
        return ResourceHolder.resource;
    }

    static class Resource {
    }

}
