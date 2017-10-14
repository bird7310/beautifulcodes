package com.ahacool.code.java.mtsafe.ini;

/**
 * Description: 多线程中最基础的初始化，使用单例。
 *              但是getInstance()会被多个地方同时调用，有可能出现数据竞争的问题。线程不安全。
 *              lv1
 *
 * @author: moto
 * @time: 17/10/14 上午9:43
 */

public class UnsafeLazyInitialization {

    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null)
            resource = new Resource(); // unsafe publication
        return resource;
    }

    static class Resource {
    }

}
