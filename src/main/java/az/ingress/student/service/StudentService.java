package az.ingress.student.service;

import az.ingress.student.dto.AddressDto;
import az.ingress.student.dto.StudentDto;
import az.ingress.student.model.Address;
import az.ingress.student.model.Group;
import az.ingress.student.model.Project;
import az.ingress.student.model.Student;
import az.ingress.student.repository.AddressRepository;
import az.ingress.student.repository.GroupRepository;
import az.ingress.student.repository.ProjectRepository;
import az.ingress.student.repository.StudentRepository;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final ProjectRepository projectRepository;
    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void createSomeData() {
        //Arrange
        Address address= new Address();
        address.setCity("Sumgait");
        address.setStreet("Mir Celal");

        Group group = Group
                .builder()
                .name("Microservices")
                .description("Microservice development students group")
                .build();
        Student student = Student.builder()
                .firstName("Ibrahim")
                .lastName("Hamidov")
                .age(26)
                .build();
        Student student1 = Student.builder()
                .firstName("Ayaz")
                .lastName("Nacafli")
                .age(27).address(address)
                .build();

        studentRepository.save(student);
        group.setStudents(Set.of(student, student1));
        groupRepository.save(group);
    }

    @Transactional
    public void listData() {
        groupRepository.findAll().forEach(
                g -> {
                    System.out.println(g);
                    g.getStudents().forEach(System.out::println);
                }
        );
    }

    @Transactional
    public List<StudentDto> fetchTypeSample() {
        return studentRepository.findAll().stream().map(s -> {
                    final StudentDto studentDto = modelMapper.map(s, StudentDto.class);
                    if (s.getAddress() != null) {
                        studentDto.setAddressDto(modelMapper.map(s.getAddress(), AddressDto.class));

                    }
                    return studentDto;
                }
        ).collect(Collectors.toList());
    }

    public List<Student> findStudentBySpecification() {
        studentRepository.findAll((root, query, cb) -> cb.equal(root.get("firstName"), "Ayaz"))
                .forEach(s -> System.out.println("Student:" + s));
        return null;
    }


}
