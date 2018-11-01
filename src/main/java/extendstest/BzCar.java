package extendstest;

/**
 * Created by hanqingsong on 18/10/23.
 *
 * @author hanqingsong
 * @date 18/10/23
 */
public class BzCar extends Car{
    private String privateName;
    public String publicName = "Bz publicName";
    public static void main(String[] args) {
        BzCar bzCar = new BzCar();

        System.out.println("BzCar");
        System.out.println(bzCar.privateName);
        // 如果子类不定义，输出为父类字段
        System.out.println(bzCar.publicName);
    }
}
