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
        String username= "13601295983"; //18614072846
        String pwd = username.substring(7);//后四位密码

        List<String> userNameList = new ArrayList<String>();

        for(int i = 0 ;i<=5;i++) {
            StringBuffer sb = new StringBuffer(username);
            sb = sb.replace(1, 2, 2+"");//修改第2位
            username = sb.replace(3, 4, i+"").toString();//2 3修改第3位
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
