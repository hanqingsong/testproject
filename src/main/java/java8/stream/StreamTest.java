package java8.stream;

import org.junit.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by hanqingsong on 17/8/17.
 * 可以把Stream当成一个高级版本的Iterator
 */
public class StreamTest {
    @Test
    public void testJava8() {
        Random random = new Random();

        // forEach
        IntStream limit = random.ints(1,10).limit(3);
        limit.forEach(System.out::println);

        System.out.println("-------map-------");
        // map
        List<Integer> nums1 = Lists.newArrayList(1,2,3);
        nums1.stream().map(n -> n * 2).forEach(System.out::println);

        System.out.println("-------filter-------");
        // filter
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println(count);

        // distinct
        System.out.println("-------distinct-------");
        List<Integer> nums3 = Lists.newArrayList(1,2,3,2);
        nums1.stream().distinct().forEach(System.out::println);

        List<Integer> nums4 = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("sum is:"+nums4.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());
    }
}
