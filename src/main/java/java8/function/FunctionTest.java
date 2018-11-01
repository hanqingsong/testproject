package java8.function;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;

/**
 * Created by hanqingsong on 17/8/17.
 * java.util.function.Predicate是在java 8中引入的functional interface。
 * Predicate用于分配lambda表达式。functional interface是返回布尔值的test（T t）。
 * 当我们将对象传递给这个方法时，它将通过分配的lambda表达式来评估对象。
 */
public class FunctionTest {

    @Test
    public void testOldHidden() {
        // File[] files = new File(".").listFiles(new FileFilter() {
        //     @Override
        //     public boolean accept(File file) {
        //         return file.isHidden();
        //     }
        // });
        //
        // File[] files1 = new File(".").listFiles(File::isHidden);


        System.out.println("FunctionTest.testOldHidden");

    }

    @Test
    public void testJava8() {
//        System.out.println( ((int x) -> x + 1));
        System.out.println("FunctionTest.testJava8");
    }



    @Test
    public void testJava8Filter() {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // List<Apple> red = filterApples(inventory, (Apple a) -> a.color.equals("red"));


        System.out.println("FunctionTest.testJava8");
    }
    //
    // public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
    //     List<Apple> result = new ArrayList<>();
    //     for(Apple apple : inventory){
    //         if(p.test(apple)){
    //             result.add(apple);
    //         }
    //     }
    //     return result;
    // }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        // public String toString() {
        //     return "Apple{" +
        //             "color='" + color + '\'' +
        //             ", weight=" + weight +
        //             '}';
        // }
    }
}
