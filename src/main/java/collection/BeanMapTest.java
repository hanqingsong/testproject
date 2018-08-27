package collection;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

/**
 * Created by hanqingsong on 18/8/2.
 *
 * @author hanqingsong
 * @date 18/8/2
 */
public class BeanMapTest {

    @Test
    public void beanTest() {
        // map2bean
        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("roomLid", "aaaaa");
        dataMap.put("teacherLid", "bbbb");
        System.out.println(dataMap);

        // LessonRoom lessonRoom1 = new LessonRoom();
        // BeanMap beanMap = BeanMap.create(lessonRoom1);
        // beanMap.putAll(dataMap);
        // System.out.println(lessonRoom1);

        // bean2map
        Map<String, Object> dataMap2 = Maps.newHashMap();
        // BeanMap beanMap2 = BeanMap.create(lessonRoom1);
        // dataMap2.putAll(beanMap2);
        // System.out.println(dataMap2);

    }

}
