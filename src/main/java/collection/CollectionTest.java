package collection;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Lists;
import com.google.common.collect.Sets;
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
    public void setString2SetInteger() {
        Set<String> set = Sets.newHashSet();
        set.add("1");
        set.add("3");
        set.add("1");
        set.add("2");

        System.out.println(set);

        String setStr = JSON.toJSONString(set);
        Set<Integer> integer = JSON.parseObject(setStr,Set.class);
        System.out.println(integer);

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

    @Test
    public void testSourt() {

        LinkedList<Map<Object, Object>> userListScoreSort = Lists.newLinkedList();
        Map<Object, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("score", 30.8112);
        Map<Object, Object> hashMap1 = new LinkedHashMap<>();
        hashMap1.put("score", 30.8111);
        Map<Object, Object> hashMap2 = new LinkedHashMap<>();
        hashMap2.put("score", 30);
        Map<Object, Object> hashMap3 = new LinkedHashMap<>();
        hashMap3.put("score", 32.933);
        userListScoreSort.add(hashMap1);
        userListScoreSort.add(hashMap);
        userListScoreSort.add(hashMap2);
        userListScoreSort.add(hashMap3);

        System.out.println(userListScoreSort);
        //排序
        Collections.sort(userListScoreSort, new Comparator<Map<Object,Object>>() {
            @Override
            public int compare(Map<Object, Object> o1, Map<Object, Object> o2) {
                String score1 = (o1.get("score")).toString();
                System.out.println(score1);
                String score2 = (o2.get("score")).toString();
                int i = score1.compareTo(score2);
                System.out.println(i);
                return i;
            }
        });
        System.out.println(userListScoreSort);
    }

    @Test
    public void testContains() {
        List<Integer> orderNumList = Arrays.asList(1, 2, 4);
        System.out.println(orderNumList.contains(1));
        System.out.println(orderNumList.contains(5));
        System.out.println(orderNumList.contains(Integer.valueOf("1")));
        System.out.println(orderNumList.contains("3"));

        Set<Integer> set = new HashSet<>();
        Iterator<Integer> iterator = set.iterator();
        Integer next = iterator.next();
        System.out.println(next);
    }

    @Test
    public void testAsList2() {
        List<String> list22 = Arrays.asList("222", "ddd", "333");
        List<String> list11 = Arrays.asList("111", "ddd",  "add", "ddd", "bbbdddd");
        // 会报错 如果需要对asList返回的List做更改，可以构造新的ArrayList，使用public ArrayList(Collection ? extends E)构造器
        boolean removeAll = list22.removeAll(list11);

        System.out.println("1 list1="+list22);
        System.out.println("1 list2="+list11);

        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("B");
        list2.add("D");
        // 并集
        list1.addAll(list2);
        System.out.println("1 list1="+list1);
        System.out.println("1 list2="+list2);

        // 去重复并集
        list1.removeAll(list2);
        System.out.println("2 list1="+list1);
        System.out.println("2 list2="+list2);

        list1.addAll(list2);
        System.out.println("3 list1="+list1);
        System.out.println("3 list2="+list2);

        // 交集
        list1.retainAll(list2);
        System.out.println("4 list1="+list1);
        System.out.println("4 list2="+list2);

        // 差集
        list1.removeAll(list2);
        System.out.println("5 list1="+list1);
        System.out.println("5 list2="+list2);
    }
}