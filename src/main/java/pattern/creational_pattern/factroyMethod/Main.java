package pattern.creational_pattern.factroyMethod;

/**
 * Created by hanqingsong on 18/4/11.
 *
 * @author hanqingsong
 * @date 18/4/11
 */
public class Main {
    public static void main(String[] args) {
        ShapeFactoryI circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactoryI squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw();
    }
}
