package proxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-12-13 09:21
 */
public class CGLibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, args);
        after();
        return result;
    }
    private void before(){
        System.out.println("before==========");
    }
    private void after(){
        System.out.println("after==========");
    }


    /**
     * 简化获取代理类方法
     * @param <T>
     * @return
     */
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
        // Enhancer enhancer = new Enhancer();
        // enhancer.setSuperclass(cls);
        // enhancer.setCallback(this);
        // return (T) enhancer.create();
    }

    private static CGLibProxy cgLibProxy = new CGLibProxy();

    public static CGLibProxy  getInstance(){
        return cgLibProxy;
    }
}
