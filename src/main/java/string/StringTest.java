package string;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.asm.Type;
import com.alibaba.fastjson.serializer.DoubleSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hanqingsong on 16/7/6.
 */
public class StringTest {
    private static String CARDDESC="{date},在“{lessonName}”课程中，你幸运的从{lessonTchName}老师送出的积分卡礼包中获得一张积分卡。领取后的积分卡可在“个人中心-我的积分卡”中进行查看。积分卡可以去积分兑换中心换取礼品哦，继续加油。";

    public void testPrint(){
        System.err.println("ddd");
    }
    public static void main(String[] args) {
//        testTrim();
        doubleT();

        isBoolean(null);
    }
    public static void isBoolean (Boolean flag){
        if (flag) {
            System.out.printf("true");
        }else {
            System.out.printf("false");
        }

    }
    public static void testTrim(){
        String str = " dd d ";
        String str2="";
        String str3 = "{\"user\":\"aaaa\"}";
        System.out.println();
        System.out.println(str.trim());
    }

    public static void  doubleT() {

        String itemDesc = CARDDESC.replace("{date}","2223").replace("{lessonName}","ddddd").replace("{lessonTchName}","ccc");

        double d = 0;
        Double d2= 200d;
        System.out.println("d=="+d);
        System.out.println("d2=="+d2);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("d", d);
        map.put("d2", d2);
        Object o = JSON.toJSON(map);
        System.out.println(o);
        SerializeConfig aa= new SerializeConfig();

        aa.put(Double.class,new DoubleSerializer("##0.00"));

        String s = JSON.toJSONString(map,aa);
        System.out.println(s);
    }

    @Test
    public void stringObjectTest() {
        String a = new String("aaa");
        System.out.println(a);
        transStrTest(a);
        System.out.println(a);

    }

    public void transStrTest(String str) {
        System.out.println(str);
        str = "bbbb";
        System.out.println(str);
    }

    @Test
    public void mapObjectTest() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("a", "aaa");
        System.out.println(hashMap);
        boolean b = transMapTest(hashMap);
        System.out.println(hashMap);
        System.out.println(b);


    }

    public boolean transMapTest(Map<String,Object> map) {
        System.out.println(map);
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("b", "bbbb");
//        map = hashMap;
        map.put("c", "ccc");
        System.out.println(map);
        return true;
    }

    @Test
    public void sbObjectTest() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaaa");
        System.out.println("out: "+stringBuffer.toString());
        tranSbTest(stringBuffer);
        System.out.println("out: "+stringBuffer.toString());

    }

    public void tranSbTest(StringBuffer sb) {
        System.out.println(sb);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" bbbb ");
        sb = stringBuffer;
        System.out.println(sb);
//        sb.append("ccc");
//        System.out.println(sb);
    }

    @Test
    public void stringNullTest() {
        String a = null;
        System.out.println(a);
        String b = a + "";
        if (null instanceof String) {
            System.out.println("string");
        }else {
            System.out.println("is not string");
        }
        System.out.println(b);

    }


    @Test
    public void splitTest() {
        String a = "aa24a5a122de4d2f86818ec517928247+1753893648_2017-06-20-19-11-30_2017-06-20-19-30-12";
        System.out.println(a.split("_")[0]);
        System.out.println("1==="+Arrays.asList(a.split("_",0)));
        System.out.println("2==="+Arrays.asList(a.split("_",1)));
        System.out.println("3==="+Arrays.asList(a.split("_",2)));
        System.out.println("4==="+Arrays.asList(a.split("_",3)));


    }


    @Test
    public void blankTest() {
        String a = " ";
        System.out.println(StringUtils.isNotBlank(a));
        System.out.println(StringUtils.isNotEmpty(a));


    }

    @Test
    public void test2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(scanner.nextLine());
    }

    private static String readDataFromConsole(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
