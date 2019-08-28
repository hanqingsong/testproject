package dozer;

import com.baidu.unbiz.easymapper.MapperFactory;
import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;

import java.util.List;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-08-28 15:29
 */
public class EasyMapperTest {

    @Data
    public class Person {
        private String firstName;
        private String lastName;
        private List<String> jobTitles;
        private long salary;
        // getter and setter...
    }
    @Data
    public class PersonDto {
        private String firstName;
        private String lastName;
        private List<String> jobTitles;
        private long salary;
        // getter and setter...
    }

    @Test
    public void test1(){
        Person p = new Person();
        p.setFirstName("NEO");
        p.setLastName("jason");
        p.setJobTitles(Lists.newArrayList("abc", "dfegg", "iii"));
        p.setSalary(1000L);
        PersonDto dto = MapperFactory.getCopyByRefMapper()
                .mapClass(Person.class, PersonDto.class)
                .registerAndMap(p, PersonDto.class);
        System.out.println(dto);
    }

}
