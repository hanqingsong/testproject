package pattern.creational_pattern.factroyMethod;

/**
 * Created by hanqingsong on 18/4/11.
 *
 * @author hanqingsong
 * @date 18/4/11
 */
public class CircleFactory implements ShapeFactoryI {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
