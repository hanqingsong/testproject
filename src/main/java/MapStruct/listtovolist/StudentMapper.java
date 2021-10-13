package MapStruct.listtovolist;

import MapStruct.Student;
import MapStruct.StudentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "gender.name", target = "gender")
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    StudentVO student2StudentVO(Student student);

    /**
     * List 转换
     *
     * @param studentList studentList
     * @return java.util.List<MapStruct.StudentVO>
     * @author hanqingsong
     * @date 2021/10/9
     */
    List<StudentVO> students2StudentVOs(List<Student> studentList);
}