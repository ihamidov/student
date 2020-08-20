package az.ingress.student.repository;

import az.ingress.student.model.Student;
import az.ingress.student.model.StudentDetails;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Long> {


}
