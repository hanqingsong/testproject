package pattern.creational_pattern.abstractFactory;

/**
 * Created by hanqingsong on 18/4/12.
 *
 * @author hanqingsong
 * @date 18/4/12
 */
public class BenzBusinessCarImpl implements BenzCar {
    @Override
    public void gasUp() {
        System.out.println("给我的奔驰商务车加一般的汽油");
    }
}
