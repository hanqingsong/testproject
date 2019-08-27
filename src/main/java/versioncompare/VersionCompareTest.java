package versioncompare;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hanqingsong on 16/7/11.
 */
public class VersionCompareTest {
    public static void main(String[] args) {
        String verson1 = "3.2.41";
        String verson2 = "3.2.31";
        String verson3 = "3.11.1";

        String fullVer1 = getFullVerStr(verson1);
        String fullVer2 = getFullVerStr(verson2);
        System.out.println("fullVer1 = " + fullVer1);
        System.out.println("fullVer2 = " + fullVer2);

        if (fullVer1.compareTo(fullVer2) > 0) {
            System.out.println(fullVer1 + " 大于 " + fullVer2);
        } else {
            System.out.println(fullVer1 + " 小于等于 " + fullVer2);
        }

        Long fullVerLong = getFullVerLong(verson1);
        Long fullVerLong2 = getFullVerLong(verson2);
        Long fullVerLong3 = getFullVerLong(verson3);
        System.out.println("fullVer1 = " + fullVerLong);
        System.out.println("fullVer2 = " + fullVerLong2);
        System.out.println("fullVer3 = " + fullVerLong3);
    }

    private static String getFullVerStr(String verStr) {
        String[] strs = verStr.split("\\.");
        StringBuilder sb = new StringBuilder();
        if (strs.length != 3) {

            return null;
        }

        for (String str : strs) {
            sb.append(StringUtils.leftPad(str, 3, '0'));
        }

        return sb.toString();
    }

    public static Long getFullVerLong(String verStr) {
        if (StringUtils.isBlank(verStr)) {
            return null;
        }
        String[] strs = verStr.split("\\.");
        Long result = 0L;
        for (String str : strs) {
            Long versonSubLong = Long.valueOf(str);
            result = result * 1000 + versonSubLong ;
        }
        return result;
    }
}
