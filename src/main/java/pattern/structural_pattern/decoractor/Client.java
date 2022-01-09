package pattern.structural_pattern.decoractor;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/31
 */
public class Client {
    public static void main(String[] args) {
        CoffeOne coffeOne = new CoffeOne();
        System.out.println("价格："+coffeOne.getPrice());
        System.out.println("描述："+coffeOne.getDesc());
        System.out.println("=====================================");
        Soy soy = new Soy(coffeOne);
        System.out.println("价格："+soy.getPrice());
        System.out.println("描述："+soy.getDesc());

        System.out.println("=====================================");
        Soy soy2 = new Soy(coffeOne);
        Milk milk = new Milk(soy2);
        System.out.println("价格："+milk.getPrice());
        System.out.println("描述："+milk.getDesc());

    }
}
