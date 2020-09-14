package az.ingress.student.service;

import az.ingress.student.model.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {// bu islenmiyecey StudentService.findStudentBySpecification() methodunun nece yarandigin gostermek ucun yaradilib
    public static Specification<Student> studentWithName(String value) {
        return (root, query, cb) -> cb.equal(root.get("firstName"), value);
    }

}
