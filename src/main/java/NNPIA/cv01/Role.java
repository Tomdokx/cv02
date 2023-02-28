package NNPIA.cv01;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity()
@Table(name="Role")
public class Role {
    @Id
    private int id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<AppUser> users;
}
