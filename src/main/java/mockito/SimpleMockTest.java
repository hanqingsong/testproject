package mockito;

import org.mockito.ArgumentMatcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-30 16:14
 * @Version 1.0
 */
public class SimpleMockTest {
    @Test
    public void testSimple(){

        //创建mock对象，参数可以是类，也可以是接口
        List<String> list = mock(List.class);

        //设置方法的预期返回值
            when(list.get(0)).thenReturn("hello mock");

        String result = list.get(0);

        //验证方法调用(是否调用了get(0))
        verify(list).get(0);

        //测试
        Assert.assertEquals("hello mock", result);
    }

    /**
     * Stubbing & 连续Stubbing
     * Stubbing(打桩)：人为介入，为Mock对象指定行为或行为发生的结果
     */
    @Test
    public void testMockStubbing() {
        // You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 连续stubbing
        when(mockedList.get(0)).thenReturn("first").thenReturn("second").thenReturn("Third");

        // following prints "first"
        System.out.println(mockedList.get(0));

        // following throws runtime exception
        System.out.println(mockedList.get(1));

        // following prints "null" because get(999) was not stubbed
        // 默认情况下，对于所有有返回值且没有stub过的方法，mockito会返回相应的默认值。
        // 对于内置类型会返回默认值，如int会返回0，布尔值返回false。对于其他type会返回null。
        System.out.println(mockedList.get(999));

        // Although it is possible to verify a stubbed invocation, usually it's just redundant
        // If your code cares what get(0) returns, then something else breaks (often even before verify() gets
        // executed).
        // If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);

        // 重复stub两次,则以第二次为准。如下将返回"second"：
        when(mockedList.get(0)).thenReturn("first");

        when(mockedList.get(0)).thenReturn("second");

        // 如果是下面这种形式，则表示第一次调用时返回“first”，第二次调用时返回“second”。可以写n多个.
        when(mockedList.get(0)).thenReturn("first").thenReturn("second");
        // 但是，如果实际调用的次数超过了stub过的次数，则会一直返回最后一次stub的值。
        // 如上例，第三次调用get(0)时，则会返回"second".
    }


    /**
     * 参数匹配
     */
    @Test
    public void testArgumentMatcher() {
        List mockedList = mock(List.class);
        // stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        // stubbing using custom matcher (let's say MyMatcher() returns your own matcher implementation):
        when(mockedList.contains(argThat(new MyMatcher()))).thenReturn(true);

        mockedList.contains("element");

        // following prints "element"
        System.out.println(mockedList.get(999));

        // you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        // argument matchers can also be written as Java 8 Lambdas
        // verify(mockedList).add(someString -> someString.length() > 5);

        File mock = mock(File.class); // 首先mock File类。
        // 注意new AnyFiles()并不是一个matcher，需要调用argThat(new IsAnyFiles()))才返回一个matcher。
        // 下句中stub：当调用renameTo方法时，返回false。该方法参数可以是任意file对象。
        when(mock.renameTo(argThat(new AnyFiles()))).thenReturn(false);
        mock.renameTo(new File("test"));

        // 下句verify renameTo方法被调用了一次，同时输入参数是任意file。
        verify(mock).renameTo(argThat(new AnyFiles()));
    }

    class MyMatcher extends ArgumentMatcher<Object> {
        @Override
        public boolean matches(Object argument) {
            if (argument != null && "element".equals(argument.toString())) {
                return true;
            }
            return false;
        }
    }

    class AnyFiles extends ArgumentMatcher<File> {
        @Override
        public boolean matches(Object file) {
            return file.getClass() == File.class;
        }
    }


    @Test
    public void testSpyMethod() {
        List<String> list = new ArrayList<>();
        List<String> listSpy = spy(list);

        listSpy.add("first-element");
        System.out.println(listSpy.get(0));

        assertEquals("first-element", listSpy.get(0));
        when(listSpy.get(0)).thenReturn("second-element");
        System.out.println(listSpy.get(0));
        assertEquals("second-element", listSpy.get(0));
    }
}
