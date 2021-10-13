package MapStruct.obj2vo;



import MapStruct.GenderEnum;
import MapStruct.Student;
import MapStruct.StudentVO;

import java.util.Date;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/10/9
 */
public class Test {
    public static void main(String[] args) {

        Student student = Student.builder().name("小明").age(6).gender(GenderEnum.Male).height(121.1).birthday(new Date()).build();

        StudentVO studentVO = StudentMapper.INSTANCE.student2StudentVO(student);
        System.out.println(studentVO);
    }
}
