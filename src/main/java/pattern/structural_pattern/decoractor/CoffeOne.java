package pattern.structural_pattern.decoractor;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/31
 */
public class CoffeOne extends Drink{
    public CoffeOne() {
        setDesc("咖啡1");
        setPrice(10);
    }

    @Override
    public float cost() {
        return super.getPrice();
    }
}
