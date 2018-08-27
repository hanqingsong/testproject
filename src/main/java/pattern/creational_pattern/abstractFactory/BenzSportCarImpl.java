package pattern.creational_pattern.abstractFactory;

/**
 * Created by hanqingsong on 18/4/12.
 * 奔驰跑车
 * @author hanqingsong
 * @date 18/4/12
 */
public class BenzSportCarImpl implements BenzCar {
    @Override
    public void gasUp() {
        System.out.println("给我的奔驰跑车加最好的汽油");
    }
}
