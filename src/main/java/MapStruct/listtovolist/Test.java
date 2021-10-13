package MapStruct.listtovolist;

import MapStruct.GenderEnum;
import MapStruct.Student;
import MapStruct.StudentVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2021/10/9
 */
public class Test {
    public static void main(String[] args) {

        Student student = Student.builder().name("小明").age(6).gender(GenderEnum.Male).height(121.1).birthday(new Date()).build();

        List<Student> list = new ArrayList<>();
        list.add(student);
        List<StudentVO> result = StudentMapper.INSTANCE.students2StudentVOs(list);
        System.out.println(result);
    }
}
