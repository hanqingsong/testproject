package pattern.creational_pattern.prototype;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/29
 */
public class SheepClient{
    public static void main(String[] args) {
        Sheep sheep = new Sheep("aaaa",33);
        Sheep clone = sheep.clone();
        System.out.println(sheep);
        System.out.println(clone);
        System.out.println(clone==sheep); // false，开辟新的内存空间不是一个对象
    }
}
