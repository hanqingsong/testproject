package proxy.dynamic;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2020-12-19 17:04
 */
public class DynamicProxyClassPrintMain {
    public static void main(String[] args) throws Exception {
        Hello hello = new HelloImpl();
        // DynamicProxy dynamicProxy = new DynamicProxy(hello);

        // Hello helloProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),
        //         hello.getClass().getInterfaces(),
        //         dynamicProxy);

        //输出动态生成代理类的字节码文件
        byte[] $proxy0s = ProxyGenerator.generateProxyClass("$proxy0", new Class[]{Hello.class});
        FileOutputStream outputStream = new FileOutputStream(new File("./$Proxy0.class"));
        outputStream.write($proxy0s);
        outputStream.flush();
        outputStream.close();
    }
}
