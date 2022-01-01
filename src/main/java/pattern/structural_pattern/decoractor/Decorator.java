package pattern.structural_pattern.decoractor;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/31
 */
public class Decorator extends Drink{
    private final Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.getPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc()+":"+super.getPrice() +" && "+ drink.getDesc()+":"+drink.getPrice();
    }

    @Override
    public float getPrice() {
        return super.getPrice() + drink.getPrice();
    }
}
