package io;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.testng.collections.Lists;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Description 修改文件格式，整理书目录格式化输出
 * @Author hanqingsong
 * @Date 2019-01-18 14:26
 * @Version 1.0
 */
public class TransFileFormat {
    @Test
    public void printTabToLine() {
        FileReader fileReader = new FileReader("/Users/hanqingsong/Desktop/区块链目录.txt");
        List<String> strings = fileReader.readLines();
        if (CollectionUtils.isNotEmpty(strings)) {
            FileWriter fileWriter = FileWriter.create(new File("/Users/hanqingsong/Desktop/区块链目录2.txt"));
            String patternStr = "(\\d?\\.\\d+)";
            Pattern pattern = Pattern.compile(patternStr);
            List<String> printStrings = Lists.newArrayList();
            for (String string : strings) {
                if (StringUtils.isBlank(string)) {
                    continue;
                }
                Matcher matcher = pattern.matcher(string);
                StringBuilder stringBuilder = new StringBuilder();
                while (matcher.find()) {
                    int count = matcher.groupCount();
                    System.out.println("匹配字符串：" + matcher.group() + "\t个数：" + count);
                    stringBuilder.append("  ");

                }
                string = stringBuilder.append(string).toString();
                System.out.println(string);
                printStrings.add(string);
            }
            fileWriter.writeLines(printStrings, false);
        }
    }
}
