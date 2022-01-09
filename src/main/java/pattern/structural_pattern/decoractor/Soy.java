package pattern.structural_pattern.decoractor;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/31
 */
public class Soy extends Decorator{
    public Soy(Drink drink) {
        super(drink);
        setDesc("豆浆");
        setPrice(22);
    }
}
