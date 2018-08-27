package pattern.creational_pattern.simpleFactory;

/**
 * Created by hanqingsong on 18/4/11.
 *
 * @author hanqingsong
 * @date 18/4/11
 */
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
    }
}
