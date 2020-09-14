package az.ingress.student.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "student")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Project.TABLE_NAME)
public class Project {

    public static final String TABLE_NAME = "projects";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    private List<Student> student;

}
