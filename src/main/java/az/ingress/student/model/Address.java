package az.ingress.student.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@ToString(exclude = "student")
@Setter
@Getter
@Table(name = Address.TABLE_NAME)
public class Address {

    public static final String TABLE_NAME = "addresses";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String street;

    @OneToOne(mappedBy = "address")
    private Student student;

    @PrePersist
    public void logNewUserAttempt() {
        log.info("This address is being saved {}", this);
    }

    @PostPersist
    public void logNewUserAdded() {
        log.info("This address has been created {}", this);
    }

    @PreRemove
    public void logUserRemovalAttempt() {
        log.info("This address is being removed {}", this);
    }

    @PostRemove
    public void logUserRemoval() {
        log.info("Address has been deleted {}", this);
    }

    @PreUpdate
    public void logUserUpdateAttempt() {
        log.info("Address is being updated {}", this);
    }

    @PostUpdate
    public void logUserUpdate() {
        log.info("Address has been updated  {}", this);
    }

    @PostLoad
    public void logUserLoad() {
        log.info("Address has been loaded {}", this);
    }


}
