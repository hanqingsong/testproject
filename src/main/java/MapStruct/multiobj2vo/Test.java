package MapStruct.multiobj2vo;

import MapStruct.Course;
import MapStruct.GenderEnum;
import MapStruct.Student;
import MapStruct.StudentVO;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Student student = Student.builder().name("小明").age(6).gender(GenderEnum.Male).height(121.1).birthday(new Date()).build();
        Course course = Course.builder().id(1L).courseName("语文").build();

        StudentVO studentVO = StudentMapper.INSTANCE.studentAndCourse2StudentVO(student, course);
        System.out.println(studentVO);
    }

}