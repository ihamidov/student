package az.ingress.student.repository;

import static org.assertj.core.api.Assertions.assertThat;

import az.ingress.student.model.Group;
import az.ingress.student.model.Student;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class GroupRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

//    @Test
//    void givenTwoStudentsAndOneGroupWhenSaveGroupThenStudentsArePersisted() {
        //Arrange
//        System.out.println("ibrahim");
//        Group group = Group
//                .builder()
//                .name("Microservices")
//                .description("Microservice development students group")
//                .build();
//        Student student = Student.builder()
//                .firstName("Ibrahim")
//                .lastName("Hamidov")
//                .age(26)
//                .build();
//        Student student1 = Student.builder()
//                .firstName("Ayaz")
//                .lastName("Nacafli")
//                .age(27)
//                .build();
//
//        studentRepository.save(student);
//        group.setStudents(Set.of(student, student1));
//        Long groupId = groupRepository.save(group).getId();
//
//        //Act
//        Optional<Group> groupFromDb = groupRepository.findById(groupId);
//
//        //Assert
//        assertThat(groupFromDb).isNotNull();
//        assertThat(groupFromDb.get().getName()).isEqualTo("Microservices");
//        assertThat(groupFromDb.get().getStudents()).isNotNull();
//        assertThat(groupFromDb.get().getStudents().stream().count()).isEqualTo(2);
//        groupFromDb.get().getStudents().forEach(s -> assertThat(s.getId()).isNotNull());
//    }
}
