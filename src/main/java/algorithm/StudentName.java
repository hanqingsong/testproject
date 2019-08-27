package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class StudentName {

    private String[] StudentName;

    public void initArray(int length) {
        StudentName = new String[length];
    }


    public void inputStudentName() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < StudentName.length; i++) {
            System.out.printf("输入第%d个名字是:", i + 1);
            StudentName[i] = sc.nextLine();
        }
    }


    public void sortStudentName() {
        // ali, ope, wei, csf, ten
        System.out.println("冒泡前的结果是：" + Arrays.asList(StudentName));
        for (int b = 0; b < StudentName.length; b++) {
            int k = b;
            for (int j1 = b; j1 < StudentName.length; j1++) {
                if (StudentName[j1].compareTo(StudentName[k]) < 0) {
                    k = j1;

                    String temp1 = StudentName[b];
                    StudentName[b] = StudentName[k];
                    StudentName[k] = temp1;
                }
            }
        }
        System.out.println("冒泡后的结果是：");
        for (int r = 0; r < StudentName.length; r++) {
            System.out.print(StudentName[r] + ".");
        }
    }


    public String getSingleStudentName() {
        String result = "StudeantName";
        int low = 0, high = 5, mid;
        String[] arr = StudentName;
        high = arr.length - 1;
        int x = StudentName.length;
        do {
            mid = (low + high) / 2;
            int[] a = null;
            if (x == a[mid]) {
                System.out.println(x + "查找 成功，在" + mid + "号位置");


            } else if (x < a[mid])
                high = mid - 1;
            else if (x > a[mid])
                low = mid + 1;
        } while (low <= high);
        System.out.println(x + "查找失败");
        return result;
    }


    public boolean isLeapYear(int year) {
        boolean isLeap = false;
        Scanner sc = new Scanner(System.in);
        int i;
        for (i = 0; i < 4; i++) {
            System.out.println("输入年份");
            int y = sc.nextInt();
            if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                System.out.println("该年是闰年");
            } else {
                System.out.println("该年是平年");
            }
        }
        return false;

    }


    public static void main(String[] args) {
        // StudentName a = new StudentName();
        // a.initArray(5);
        // a.inputStudentName();
        // a.sortStudentName();
        // a.isLeapYear(0);
        // a.getSingleStudentName();

        String[] nameArr = new String[]{"ali", "csf", "ope","ppe", "ten", "wei"};
        String inputName = "csf";
        new StudentName().findStudentName(nameArr, inputName);
    }

    public void findStudentName(String[] nameArr, String inputName) {
        int length = nameArr.length-1;
        int high = length;
        int low = 0;
        int mid = 0;
        char firstChar = inputName.charAt(0);
        int i=1;
        while (low <= high) {
            System.out.println("第" + i +"次");
            System.out.println("low=" + low + ",high=" + high);
            mid = (low + high) / 2;
            String middleStr = nameArr[mid];
            if (middleStr == inputName) {
                System.out.println("找到数据:" + mid);
                break;
            } else {
                char midChar = middleStr.charAt(0);
                if (firstChar > midChar) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
            i++;
        }
    }
}

	
        
        
        
        	
        		
        		
    