package json;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by hanqingsong on 16/7/12.
 */
public class JsonTest {
    public static void main(String[] args) {
        String jsonStr = "{\n   \"params\" : {\n      \"lesson_lid\" : \"12132164321dx\",\n      \"quiz_id\" : 12314215\n   },\n   \"request_content\" : \"top3\",\n   \"request_from\" : \"teacher\"\n}\n";

        Map<String,Object> map = JSON.parseObject(jsonStr, Map.class);
        System.out.println(map);
        Map params = (Map) map.get("params");
        System.out.println("1==="+ params);
        Integer quiz_id = (Integer) params.get("quiz_id");
        System.out.println("1===quiz_id="+ quiz_id);
        Long quiz_idL = quiz_id.longValue();
        System.out.println("2==quiz_id="+ quiz_id);
    }
}
