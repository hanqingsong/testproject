package pattern.structural_pattern.decoractor;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/31
 */
public class CoffeTwo extends Drink{
    public CoffeTwo() {
        setDesc("咖啡2");
        setPrice(20);
    }

    @Override
    public float cost() {
        return super.getPrice();
    }
}
