package az.ingress.student;

import az.ingress.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class StudentApplication implements CommandLineRunner {

    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }



    @Override
    public void run(String... args) {
        studentService.createSomeData();
//        studentService.listData();
//        studentService.fetchTypeSample().stream().forEach(System.out::println);
        studentService.findStudentBySpecification();
    }
}


