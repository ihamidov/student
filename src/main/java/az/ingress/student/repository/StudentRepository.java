package az.ingress.student.repository;

import az.ingress.student.model.Student;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByFirstNameStartsWith(String predicate);

    List<Student> findByFirstNameStartsWithAndLastNameStartsWith(String firstName, String lastName);

    @Query("SELECT s FROM Student s WHERE LOWER(s.lastName) = LOWER(:lastName)")
    List<Student> withMyQuery(@Param("lastName")String lastName);

    @Query(value = "select * from student where first_name like :firstName%",nativeQuery = true)
    List<Student> withMyQueryNativeQuery(@Param("firstName")String firstName);

    //namequery
    List<Student> findByAgeNamed(String age);
}
