package collection;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import sun.plugin.cache.FileVersion;

import java.util.*;

/**
 * Created by hanqingsong on 16/8/10.
 */
public class CollectionTest {

    @Test
    public void array2ListTest() {
//        List<String> list = new ArrayList<String>();
//        String[] stringArray = (String[]) list.toArray();
//        List<String> strings = Arrays.asList(stringArray);

        int i = 0;
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        stringObjectHashMap.put("a", ++i);
        stringObjectHashMap.put("b", ++i);
        System.out.println(stringObjectHashMap);

        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(null);
        list.add(2);
        System.out.println(list);


    }

    @Test
    public void array2ListTest2() {
        List<String> lines = new ArrayList<String>();
        for (int m = 0; m < 134; m++) {
            lines.add(m + "");
        }
        System.out.println("初始值:" + lines);

        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            i++;
            String mobileStr = line;
            if (StringUtils.isNotBlank(mobileStr)) {
                sb.append(mobileStr);
                sb.append(",");
            } else {
                System.err.println("第[" + i + "]行手机号为空.");
            }

            if (i % 10 == 0 || i == lines.size()) {//10条
                try {
                    System.out.println("发送10条短信" + sb.substring(0, sb.length() - 1));
                    sb = new StringBuilder();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }
            }

        }
    }

    @Test
    public void mapString() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        String aaa = "aaa ";
        stringObjectHashMap.put("a", aaa);
        System.out.println(stringObjectHashMap);
        aaa = "bbbb";
        System.out.println(stringObjectHashMap);


    }

    /**
     * linkedset去重
     */
    @Test
    public void LinkedSetTest() {
        LinkedHashSet<String> set1 = new LinkedHashSet<String>(); //3
        set1.add("one_n");
        set1.add("two");
        set1.add("three");
        System.out.println(set1);
        LinkedHashSet<String> set2 = new LinkedHashSet<String>();//new
        set2.add("one_n");
        set2.add("four");
        set2.add("five");
        set1.add("four");
        set1.add("three");
        System.out.println(set2);
        LinkedHashSet<String> set3 = new LinkedHashSet<String>();
        set3.add("four");
        set3.add("five");
        set3.add("six");
        System.out.println(set3);

        set1.addAll(set2);
        set1.addAll(set3);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);

        String string = set3.toString();
        System.out.println(string);
        if (string.contains("five")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test
    public void listSizeTest() {

        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>(3);

        System.out.println(strings1);
        System.out.println(strings2);
//        System.out.println(strings1.get(0));
//        System.out.println(strings2.get(0));
        System.out.println(JSON.toJSONString(null));
        System.out.println(JSON.toJSONString(null));

    }

    @Test
    public void listStringTreeMap() {
        Map<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("usertoken", "353f35d1b2504332962c460bf59779a0");
        hashMap.put("lessonLid","70887786da0b43eb8f7d43529e6051d2" );
        System.out.println(JSON.toJSONString(hashMap));
        hashMap = new TreeMap<>(hashMap);
        System.out.println(JSON.toJSONString(hashMap));
    }
}