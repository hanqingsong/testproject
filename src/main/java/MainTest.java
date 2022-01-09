import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by hanqingsong on 17/8/1.
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print(scanner.nextLine());
        // System.out.print(System.currentTimeMillis());
        int i = 0;
        do {

            i++;
            // System.out.println(i);
            String type = getType();
            if (type.equals("aaa")) {
                System.out.println("jieshu");
                break;
            }
            // TimeUnit.SECONDS.sleep(1);
            System.out.println("next");

        } while (true);
    }

    private static String getType(){
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入：");
        String readLine = null;
        try {
            readLine = strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLine;
    }
}
