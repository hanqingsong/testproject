package pattern.creational_pattern.abstractFactory;

public class TeslaSportCar implements TeslaCar {
    @Override
    public void charge() {
        System.out.println("给我特斯拉跑车冲满电");
    }
}
