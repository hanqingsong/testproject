package io;
 
import java.io.*;
import java.util.*;
public class Test6
{
    public static void main(String[] args) throws Exception
    {
        String s = "/Users/hanqingsong/Desktop/test/c.mp3"; // 输出目录 & 文件名
        List<String> list = new ArrayList<String>();
        File dir = new File("/Users/hanqingsong/Desktop/test"); // 要遍历的目录, 用递归拿文件,文件太多就完蛋.
        recursion(dir.listFiles(), list); // 递归函数
        String[] ss = new String[list.size()];
        for (int i = 0; i < ss.length; i++)
        {
            ss[i] = list.get(i);
        }
        System.out.println();
        combine(s, ss);
    }
    public static void recursion(File[] fs, List<String> list) // 递归得所有子目录的.mp3文件.
    {
        for (File f : fs)
        {
            if (f.isDirectory())
            {
                recursion(f.listFiles(), list);
            }
            else
            {
//                if (f.getName().endsWith(".pcm"))
                {
                    list.add(f.getAbsolutePath());
                }
            }
        }
    }
    private static boolean combine(String outFile, String[] inFiles) throws Exception
    {
        File out = new File(outFile);
        File[] files = new File[inFiles.length];
        for (int i = 0; i < files.length; i++)
        {
            files[i] = new File(inFiles[i]);
        }
        FileInputStream fis = null;
        FileOutputStream fos = new FileOutputStream(outFile, true); // 合并其实就是文件的续写,写成true
        for (int i = 0; i < files.length; i++)
        {
            fis = new FileInputStream(files[i]);
            int len = 0;
            for (byte[] buf = new byte[1024 * 1024]; (len = fis.read(buf)) != -1;)
            {
                fos.write(buf, 0, len);
            }
        }
        fis.close();
        fos.close();
        return true;
    }
}