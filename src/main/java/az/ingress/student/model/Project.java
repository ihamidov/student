package az.ingress.student.model;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString(exclude = "student")
@Table(name = Project.TABLE_NAME)
public class Project {
    public static final String TABLE_NAME="project";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String description;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> student;
}
