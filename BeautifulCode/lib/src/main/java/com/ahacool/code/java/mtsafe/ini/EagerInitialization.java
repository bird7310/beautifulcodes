package com.ahacool.code.java.mtsafe.ini;

/**
 * Description: 为了避免lv2中getInstance()同步开销，使用提前初始化。
 *              提前初始化方法利用静态初始化提前加载并有同步机制保护的特性实现了安全发布。
 *              lv3
 *
 * @author: moto
 * @time: 17/10/14 上午9:40
 */

public class EagerInitialization {

    private static Resource resource = new Resource();

    public static Resource getResource() {
        return resource;
    }

    static class Resource {
    }

}
