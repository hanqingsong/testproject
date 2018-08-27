package pattern.creational_pattern.abstractFactory;

public class TeslaBusinessCar implements TeslaCar {
    @Override
    public void charge() {
        System.out.println("不用给我特斯拉商务车冲满电");
    }
}
