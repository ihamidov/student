package az.ingress.student.repository;

import az.ingress.student.model.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    Optional<Student> findByFirstNameStartsWith(String predicate);

    List<Student> findByFirstNameStartsWithAndLastNameStartsWith(String firstName, String lastName);

    @Query("SELECT s FROM Student s WHERE LOWER(s.lastName) = LOWER(:lastName)")
        //JPA  query, SQL
    List<Student> findWithMyAwsomeQuery(@Param("lastName") String lastName);

    @Query(
            value = "SELECT * FROM students s WHERE s.first_name like :firstName%  and  s.last_name like :lastName%",
            nativeQuery = true)
    List<Student> findAllStudentsNative(@Param("firstName") String firstName, @Param("lastName") String lastName);

    //Graph database

    List<Student> findByAgeNamed(String age);
}
