package com.ahacool.code.java.mtsafe.ini;

/**
 * Description: 单例+上锁，实现线程安全。
 *              lv2
 *
 * @author: moto
 * @time: 17/10/14 上午9:39
 */

public class SafeLazyInitialization {

    private static Resource resource;

    //一线程获得内置锁之后，在释放锁之前的操作都会先于另外一个线程得到锁的操作执行
    public synchronized static Resource getInstance() {
        if (resource == null)
            resource = new Resource();
        return resource;
    }

    static class Resource {
    }

}
