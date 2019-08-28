package dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.junit.Test;

/**
 * @author hanqingsong
 * @version 1.0
 * @date 2019-08-28 15:10
 */
public class DozerTest {
    @Test
    public void test1(){
        // 不同类型数据转换
        DozerBeanMapper  mapper = new DozerBeanMapper();
        Source2 source = new Source2("320", 15.2);
        Dest2 dest = mapper.map(source, Dest2.class);
        System.out.println(dest);
    }

    @Test
    public void test2(){
        BeanMappingBuilder builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Person.class, Personne.class)
                        .fields("name", "nom")
                        .fields("nickname", "surnom").exclude("age");
            }
        };

        DozerBeanMapper  mapper = new DozerBeanMapper();
        mapper.addMapping(builder);
        // 不同字段名映射
        Personne frenchAppPerson = new Personne("Sylvester Stallone", "Rambo", 70);
        Person englishAppPerson = mapper.map(frenchAppPerson, Person.class);
        System.out.println(englishAppPerson);
    }

}
