package az.ingress.student.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@NamedQuery(name = "Student.findByAgeNamed", query = "SELECT s FROM Student s WHERE age=?1")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_address")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;

    @ManyToMany(            fetch = FetchType.EAGER ,cascade = { CascadeType.ALL })
    @JoinTable(
            name = "groups_students",
            joinColumns =  @JoinColumn(name = "student_id") ,
            inverseJoinColumns =  @JoinColumn(name = "group_id")
    )
    private Set<Group> groups= new HashSet<>();;
}
