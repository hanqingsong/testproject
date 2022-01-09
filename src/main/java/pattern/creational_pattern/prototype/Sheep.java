package pattern.creational_pattern.prototype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/29
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sheep implements Cloneable{
    private String name;
    private Integer age;



    @Override
    public Sheep clone() {
        try {
            Sheep clone = (Sheep) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
