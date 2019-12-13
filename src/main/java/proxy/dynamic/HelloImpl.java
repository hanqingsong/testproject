package proxy.dynamic;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-12-13 08:44
 */
public class HelloImpl implements Hello {
    @Override
    public void say() {
        System.out.println("say hello");
    }
}
