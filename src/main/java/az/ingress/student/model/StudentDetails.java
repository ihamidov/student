package az.ingress.student.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class StudentDetails {
    @Id
    @Column(unique = true, nullable = false)
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Student student;

    private String description;


}
