package java8.stream;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description
 * @Author hanqingsong
 * @Date 2019-01-24 14:11
 * @Version 1.0
 */
public class ListStreamTest {
    @Test
    public void oneTest(){
        Random random = new Random();
        IntStream ints = random.ints().limit(10);
        System.out.println(ints.toArray());
        IntStream range = IntStream.range(1, 20);
        // range.forEach(System.out::println);

        ArrayList<String> strings = CollUtil.newArrayList("one", "two", "three");
        Stream<String> stream = strings.stream();
        Optional<String> first = stream.findAny();
        String firstStr = first.get();
        System.out.println(firstStr);

        stream.map(s -> {
            System.out.println(s);
            return true;
        });
        Collector<Object, ?, List<Object>> objectListCollector = Collectors.toList();
    }

    /**
     * 过滤掉长度大于3的字母，拼接字符串输出
     */
    @Test
    public void filterTest(){
        ArrayList<String> strings = CollUtil.newArrayList("one", "dasdf","two", "three");
        strings.stream()
                .filter(s -> s.length()>3)
                .map(s -> "长度大于3："+s)
                .forEach(System.out::println);
    }

    /**
     * 转换单词为数字
     */
    @Test
    public void map2Test(){
        ArrayList<String> strings = CollUtil.newArrayList("one", "dasdf","two", "three");
        List<Object> list = strings.stream()
                .map(s -> {
                    int i = 0;
                    if (s.equals("one")) {
                        i=1;
                    }
                    return i;
                }).collect(Collectors.toList());
        System.out.println(list);

    }
    @Test
    public void mapToTest(){
        User user1 = new User("a", 1,60.88);
        User user2 = new User("b", 2,88.23);
        ArrayList<User> users = CollUtil.newArrayList(user1,user2);
        List<Integer> list = users.stream()
                .mapToInt(user -> user.getWeight().intValue()).boxed().collect(Collectors.toList());
        List<String> collect = users.stream().map(User::getName).collect(Collectors.toList());
        Map<String, User> collect1 = users.stream().collect(Collectors.toMap(User::getName, v -> v));

        String string = users.stream().map(User::getName).collect(Collectors.joining(",")).toString();
        System.out.println(string);
        System.out.println(collect1);
        System.out.println(collect);
        System.out.println(list);
        StringJoiner stringjoin = new StringJoiner(",");
        stringjoin.add("dfdafa");
        stringjoin.add("dfdafa");
        System.out.println(stringjoin);
        Objects.requireNonNull(stringjoin);
    }

    @Data
    @AllArgsConstructor
    class User {
        private String name;
        private int age;
        private Double weight;
    }

    /**
     * 计算和
     */
    @Test
    public void sumTest(){
        ArrayList<String> strings = CollUtil.newArrayList("one", "dasdf","two", "three");

        int one = strings.stream()
                .map(s -> {
                    int i = 0;
                    if (s.equals("one")) {
                        i = 1;
                    } else if (s.equals("two")) {
                        i = 2;
                    }
                    return i;
                }).mapToInt(d -> d).sum();
        System.out.println(one);

    }
    /**
     * 转为大写
     */
    @Test
    public void upperTest(){
        ArrayList<String> strings = CollUtil.newArrayList("one", "dasdf","two", "three");

        List<String> collect = strings.stream()
                .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * peek,类似一次terminal操作
     */
    @Test
    public void peekTest(){
        ArrayList<String> strings = CollUtil.newArrayList("one", "dasdf","two", "three");

        strings.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .map(String::toLowerCase)
                .forEach(System.out::println);

    }


}
