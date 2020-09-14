package az.ingress.student.controller;

import az.ingress.student.config.AppConfig;
import az.ingress.student.dto.GenericSearchDto;
import az.ingress.student.dto.StudentDto;
import az.ingress.student.model.Student;
import az.ingress.student.service.StudentInfoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("student")
@RequiredArgsConstructor
public class StudentController {

    private final AppConfig appConfig;

    private final StudentInfoService studentInfoService;

    @GetMapping("/details")
    public String getAppDetails() {
        appConfig.getDevelopers().stream().forEach(System.out::println);
        appConfig.getNumbers().forEach((k, v) -> System.out.println(k + "=" + v));
        return appConfig.getName() + " My Version:" + appConfig.getName();

    }

//    @GetMapping
//    public StudentDto getStudent(@RequestParam Long id) {
//        return studentInfoService.findStudentById(id);
//    }

    @GetMapping
    public List<Student> findAll(@RequestParam String firstName, @RequestParam String lastName) {
        log.trace("Received request with query params {} {}", firstName, lastName);
        return studentInfoService.findByFirstAndLastName(firstName,lastName);
    }

    @PostMapping
    public void createStudent(@RequestBody StudentDto student) {
        studentInfoService.createStudent(student);
    }

    @PostMapping("/search")
    public Page<StudentDto> searchStudents(@RequestBody GenericSearchDto search, Pageable pageable) {
        return studentInfoService.search(search, pageable);

    }

}
