package az.ingress.student.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "students")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Group.TABLE_NAME)
public class Group {

    public static final String TABLE_NAME = "groups";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

//    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Student> students;
}
