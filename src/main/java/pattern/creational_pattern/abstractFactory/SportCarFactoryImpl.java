package pattern.creational_pattern.abstractFactory;

/**
 * Created by hanqingsong on 18/4/12.
 *
 * @author hanqingsong
 * @date 18/4/12
 */
public class SportCarFactoryImpl implements CarFactory {
    @Override
    public BenzCar getBenzCar() {
        return new BenzSportCarImpl();
    }

    @Override
    public TeslaCar getTeslaCar() {
        return new TeslaSportCar();
    }
}
