package az.ingress.student.service;

import az.ingress.student.dto.StudentDto;
import az.ingress.student.exceptionns.StudentNotFoundException;
import az.ingress.student.model.Student;
import az.ingress.student.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class StudentInfoService {

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;

    public void createStudent(StudentDto studentDto) {
        studentRepository.save(mapper.map(studentDto, Student.class));
    }

    public Student findStudent(String prefix) {
        return studentRepository.findByFirstNameStartsWith(prefix)
                .orElseThrow(() -> new RuntimeException("Nothing is found"));
    }

    public StudentDto findStudentById(Long id) {
        return studentRepository.findById(id)
                .map((s) -> mapper.map(s, StudentDto.class))
                .orElseThrow(StudentNotFoundException::new);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findByFirstAndLast(String firstName, String lastName) {
        return studentRepository.findByFirstNameStartsWithAndLastNameStartsWith(firstName,lastName);

    }

    public List<Student> findByLastNameWithMyQuery(String lastName) {
        return studentRepository.withMyQuery(lastName);

    }

    public List<Student> withMyQueryNativeQuery(@RequestParam String firstName) {
        return studentRepository.withMyQueryNativeQuery(firstName);

    }
}
