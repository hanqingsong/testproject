package proxy.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-12-16 09:34
 */
public class GreetingMain {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new HelloNoInterface());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        HelloNoInterface proxy = (HelloNoInterface)proxyFactory.getProxy();
        proxy.say();
    }
}
