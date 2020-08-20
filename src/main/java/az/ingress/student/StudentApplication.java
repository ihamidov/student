package az.ingress.student;

import az.ingress.student.model.Address;
import az.ingress.student.model.Project;
import az.ingress.student.model.Student;
import az.ingress.student.model.StudentDetails;
import az.ingress.student.repository.AddressRepository;
import az.ingress.student.repository.StudentDetailsRepository;
import az.ingress.student.repository.StudentRepository;
import az.ingress.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

@RequiredArgsConstructor
@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

    private  final StudentRepository studentRepository;
    private final AddressRepository addressRepository;
    private final StudentDetailsRepository studentDetailsRepository;
    public final StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
//        studentRepository.findByAgeNamed("26").stream()
//                .forEach(System.out::println);}//named queryni run edir

//        PageRequest pageRequest=PageRequest.of(0,2);//2-2 pagelere yigir/pageler 0 dan basdiyirk
//        studentRepository.findAll(pageRequest).stream().forEach(System.out::println);
//        studentRepository.findAll().forEach(s-> System.out.println(s.getAddress()));

        studentService.createData();
        studentService.listData();


//createData();

    }

//    public void createData(){
//        Project project= new Project();
//        project.setName("LMS");
//        project.setDescription("description yazilan hisse");
//
//        Student student= new Student();
//        student.setFirstName("Ibrahim");
//        student.setLastName("Hamidov");
//        student.setAge("22");
//        Address address= new Address();
//        address.setStreet("Mir Celal");
//        address.setCity("Sumqayit");
//        student.setAddress(address);
//        student.setProject(project);
////        studentRepository.save(student);
//
//        Student student1= new Student();
//        student1.setFirstName("Ayaz");
//        student1.setLastName("Nacafli");
//        student1.setAge("22");
//        Address address1= new Address();
//        address1.setStreet("Hezi Aslanov");
//        address1.setCity("Baku");
//        student1.setAddress(address1);
//        student1.setProject(project);
//
//        studentRepository.save(student1);
//        studentRepository.findAll().forEach(System.out::println);
//        addressRepository.findAll().forEach(System.out::println);
//
//
//    }
}


