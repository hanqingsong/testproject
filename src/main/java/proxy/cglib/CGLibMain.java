package proxy.cglib;


import net.sf.cglib.proxy.Enhancer;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-12-13 09:21
 */
public class CGLibMain {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        HelloNoInterface helloProxy = (HelloNoInterface) Enhancer.create(HelloNoInterface.class, cgLibProxy);
        helloProxy.say();
        System.out.println("===============");

        // 优化：每次使用 Enhancer.create 比较麻烦，封装到DynamicProxy中
        HelloNoInterface helloProxy2 = cgLibProxy.getProxy(HelloNoInterface.class);
        helloProxy2.say();

        System.out.println("===============");
        // 优化：使用单例模式获取对象
        HelloNoInterface helloProxy3 = CGLibProxy.getInstance().getProxy(HelloNoInterface.class);
        helloProxy3.say();

    }
}
