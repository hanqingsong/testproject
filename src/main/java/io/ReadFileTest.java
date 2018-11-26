package io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by hanqingsong on 18/11/25.
 *
 * @author hanqingsong
 * @date 18/11/25
 */
public class ReadFileTest {
    @Test
    public void readRile(){
        String path = "/Users/hanqingsong/Desktop/lb.json";
        try {
            String fileToString = FileUtils.readFileToString(new File(path));
            JSONObject jsonObject = JSON.parseObject(fileToString);
            JSONArray children = jsonObject.getJSONArray("children");
            JSONArray leftChildren = jsonObject.getJSONArray("leftChildren");
            // printChildrent(children, 1);
            printChildrent(leftChildren, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     {
     "children": [],
     "id": "a4381b7187e1",
     "parent": "54b0ea926de8",
     "title": "线程通讯"
     },
     * @param array
     */
    private void printChildrent(JSONArray array,int ceng) {

        if (CollectionUtils.isEmpty(array)) {
            return;
        }
        for (int i = 0; i < array.size(); i++) {
            int temp=ceng;
            JSONObject jsonObject = array.getJSONObject(i);
            String title = jsonObject.getString("title");
            JSONArray children = jsonObject.getJSONArray("children");
            for (int j =1;j<temp;j++) {
                System.out.print("\t");
            }
            System.out.print(title+"\n");
            printChildrent(children,++temp);
        }

    }
}
