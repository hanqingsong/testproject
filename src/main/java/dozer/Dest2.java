package dozer;

import lombok.Data;

@Data
public class Dest2 {
    private int id;
    private int points;
 
    public Dest2() {}
 
    public Dest2(int id, int points) {
        super();
        this.id = id;
        this.points = points;
    }
     
    // standard getters and setters
}