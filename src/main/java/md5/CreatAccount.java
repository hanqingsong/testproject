package md5;

import sun.applet.Main;
import sun.jvm.hotspot.debugger.linux.LinuxDebugger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hanqingsong on 16/7/26.
 */
public class CreatAccount {
    public static void main(String[] args) {
        String username= "18801107603"; //18614072846
        String pwd = username.substring(7);//后四位密码

        List<String> userNameList = new ArrayList<String>();
        int count = 9;
        for(int i = 0 ;i<=count;i++) {
            StringBuffer sb = new StringBuffer(username);
            int replace2Num = 2;
            int replaceOrderNum = 4;
            sb = sb.replace(replace2Num-1, replace2Num, 2+"");//修改第2位
            username = sb.replace(replaceOrderNum-1, replaceOrderNum, i+"").toString();//2 3修改第3位
            String userlid = UUIDGenerator.generate();
            String token = UUIDGenerator.generate();
            String pwdCrypt = MD5.crypt(pwd);

            Date nowDate = new Date();

            String insertSQL = "INSERT INTO `user` (`lid`, `username`, `pwd`, `token`, `openid`, `device_lid`, `role_type`, `status`, `create_time`, `udpate_time`)\n" +
                    "VALUES\n" +
                    "\t('"+userlid+"', '"+username+"', '"+pwdCrypt+"', '"+token+"', NULL, NULL, 1, 1, now(), now());\n";

            userNameList.add(username);

            System.out.println(insertSQL);
        }
        System.out.println("测试账号: 密码="+pwd+"\t 账号="+userNameList);

    }
}
