package java8.function;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2022/3/23
 */
public class FunctionalTest {

    @Test
    public void testFunction(){
        String result = function("hello", s -> s + ",hi");
        System.out.println(result);
    }
    /**
     * 函数型接口，有输入，有输出
     * @param name
     * @param function
     */
    public String function(String name, Function<String,String> function){
        name = name.toUpperCase();
        return function.apply(name);
    }


    @Test
    public void testConsumer(){
        consumer("hello", s -> System.out.println(s+",hi"));
    }
    /**
     * 消费型接口，有输入，没有输出
     */
    public void consumer(String name, Consumer<String> consumer){
        name = name.toUpperCase();
        consumer.accept(name);
    }

    @Test
    public void testSupplier(){
        String result = supplier("hello", () -> " ,hi");
        System.out.println(result);
    }
    /**
     * 供给型接口，没有输入，有输出
     */
    public String supplier(String name, Supplier<String> consumer){
        name = name.toUpperCase();
        String getRes = consumer.get();
        return name + getRes;
    }


    @Test
    public void testPredicate(){
        boolean result = predicate("hello", s -> s.length()>2);
        System.out.println(result);
    }
    /**
     * 断言型接口，有输入，有输出，输出为Boolean
     */
    public boolean predicate(String name, Predicate<String> predicate){
        boolean test = predicate.test(name);
        return test;
    }


    @Test
    public void testPredicate2(){
         ConcurrentMap<String, String> subscribed = new ConcurrentHashMap<>();
        String listeners = subscribed.computeIfAbsent("2333", n -> n+",kkkkkk");

        System.out.println(JSON.toJSONString(subscribed));
    }



}
