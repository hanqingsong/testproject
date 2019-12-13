package proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-12-13 08:43
 */
public class DynamicMain {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        hello.say();

        // 使用动态代理
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloProxy = (Hello)Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                dynamicProxy);
        helloProxy.say();

        System.out.println("==========优化");
        // 优化：每次使用Proxy.newProxyInstance比较麻烦，封装到DynamicProxy中
        DynamicProxy dynamicProxy2 = new DynamicProxy(hello);
        Hello helloProxy2 = dynamicProxy2.getProxy();
        helloProxy2.say();
    }
}
