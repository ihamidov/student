package az.ingress.student.service;

import az.ingress.student.dto.GenericSearchDto;
import az.ingress.student.dto.StudentDto;
import az.ingress.student.exceptionns.StudentNotFoundException;
import az.ingress.student.model.Student;
import az.ingress.student.repository.StudentRepository;
import az.ingress.student.search.SearchSpecification;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public List<Student> findByFirstAndLastName(String firstName, String lastName) {
        //return studentRepository.findByFirstNameStartsWithAndLastNameStartsWith(firstName,lastName);
        //return studentRepository.findWithMyAwsomeQuery(lastName);
       // String firstNameLike=firstName+"%";
       // String lastNameLike=lastName+"%";
        return studentRepository.findAllStudentsNative(firstName,lastName);
    }

    @Transactional
    public Page<StudentDto> search(GenericSearchDto filter, Pageable pageable) {
        return studentRepository.findAll(new SearchSpecification<>(filter.getCriteria()), pageable)
                .map(p -> mapper.map(p, StudentDto.class));
    }

}
