package pattern.structural_pattern.decoractor;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/31
 */
public class Milk extends Decorator{
    public Milk(Drink drink) {
        super(drink);
        setDesc("牛奶");
        setPrice(11);
    }
}
