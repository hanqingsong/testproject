package pattern.structural_pattern.decoractor;

import lombok.Data;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/12/31
 */
@Data
public abstract class Drink {
    private String desc;
    private float price;

    public abstract float cost();
}
