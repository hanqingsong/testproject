package pattern.creational_pattern.abstractFactory;

public interface CarFactory {

    public BenzCar getBenzCar();
    public TeslaCar getTeslaCar();
}