package java8.foreach;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-06-17 11:29
 */
public class ForeachTest {
    @Test
    public void foreachNullTest() {
        List list = null;
        // NullPointerException
        list.stream().forEach(a->{
            System.out.println("aaa");
        });
        // NullPointerException
        list.forEach(a->{
            System.out.println("aaa");
        });

    }
    @Test
    public void foreachNullTest2() {
        List list = getList();
        Optional.ofNullable(list).ifPresent(l-> l.forEach(System.out::println));
        Optional.ofNullable(list).ifPresent(l-> l.forEach(System.out::println));
        // Optional.ofNullable(list).map(e->e.forEach(System.out::println));
    }

    private List getList(){
        int a =1;
        List list =null;
        if (a == 1) {
            list = Lists.newArrayList("a", "b", "c");
        }
        return list;
    }
}
