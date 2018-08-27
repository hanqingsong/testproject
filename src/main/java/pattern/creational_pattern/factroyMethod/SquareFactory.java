package pattern.creational_pattern.factroyMethod;

/**
 * Created by hanqingsong on 18/4/12.
 *
 * @author hanqingsong
 * @date 18/4/12
 */
public class SquareFactory implements ShapeFactoryI {
    @Override
    public Shape createShape() {
        return new Square();
    }
}
