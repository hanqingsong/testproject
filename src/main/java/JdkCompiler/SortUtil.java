package JdkCompiler;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

public class SortUtil {
    /**
     * @param param   参数
     * @param encode  编码
     * @param isLower 是否小写
     * @return
     */
    public static String formatUrlParam(Map<String, String> param, String encode, boolean isLower) {
        String params = "";
        Map<String, String> map = param;

        try {
            List<Entry<String, String>> itmes = new ArrayList<Entry<String, String>>(map.entrySet());

            //对所有传入的参数按照字段名从小到大排序
            //Collections.sort(items); 默认正序
            //可通过实现Comparator接口的compare方法来完成自定义排序
            Collections.sort(itmes, new Comparator<Entry<String, String>>() {
                @Override
                public int compare(Entry<String, String> o1, Entry<String, String> o2) {
                    return (o1.getKey().toString().compareTo(o2.getKey()));
                }
            });

            //构造URL 键值对的形式
            StringBuffer sb = new StringBuffer();
            for (Entry<String, String> item : itmes) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    val = URLEncoder.encode(val, encode);
                    if (isLower) {
                        sb.append(key.toLowerCase() + "=" + val);
                    } else {
                        sb.append(key + "=" + val);
                    }
                    sb.append("&");
                }
            }

            params = sb.toString();
            if (!params.isEmpty()) {
                params = params.substring(0, params.length() - 1);
            }
        } catch (Exception e) {
            return "";
        }
        return params;
    }

}
