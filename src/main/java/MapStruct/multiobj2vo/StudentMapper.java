package MapStruct.multiobj2vo;

import MapStruct.Course;
import MapStruct.Student;
import MapStruct.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "student.gender.name", target = "gender")
    @Mapping(source = "student.birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "course.courseName", target = "course")
    StudentVO studentAndCourse2StudentVO(Student student, Course course);

}