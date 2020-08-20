package az.ingress.student.service;

import az.ingress.student.model.Address;
import az.ingress.student.model.Group;
import az.ingress.student.model.Project;
import az.ingress.student.model.Student;
import az.ingress.student.repository.AddressRepository;
import az.ingress.student.repository.GroupRepository;
import az.ingress.student.repository.ProjectRepository;
import az.ingress.student.repository.StudentRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final ProjectRepository projectRepository;
    private final GroupRepository groupRepository;

    @Transactional
    public void createData(){
        Project project= new Project();
        project.setName("LMS");
        project.setDescription("description yazilan hisse");

        Student student= new Student();
        student.setFirstName("Ibrahim");
        student.setLastName("Hamidov");
        student.setAge("22");
        Address address= new Address();
        address.setStreet("Mir Celal");
        address.setCity("Sumqayit");
        student.setAddress(address);
        student.setProject(project);
        studentRepository.save(student);


        Group group= new Group();





        Student student1= new Student();
        student1.setFirstName("Ayaz");
        student1.setLastName("Nacafli");
        student1.setAge("22");
        Address address1= new Address();
        address1.setStreet("Hezi Aslanov");
        address1.setCity("Baku");
        student1.setAddress(address1);
        student1.setProject(project);
        studentRepository.save(student1);

    }

    @Transactional
    public void listData(){
//        studentRepository.findAll().forEach(System.out::println);
        projectRepository.findAll().forEach(project->
        {System.out.println(project);
                project.getStudent().forEach(System.out::println);}
        );

    }




}
