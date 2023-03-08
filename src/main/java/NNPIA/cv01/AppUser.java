package NNPIA.cv01;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/*
* none, validate, update, create-drop
* */
@Getter
@Setter
@Entity
@ToString
@DynamicInsert
@DynamicUpdate
@Table(name="AppUser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    @NotNull
    @NotEmpty
    @Max(255)
    private String username;
    @Column
    private String password;
    @Column
    private boolean active;
    @Column
    private LocalDate creation_date;
    @Column
    private LocalDate update_date;

    @OneToMany(mappedBy = "author_id")
    @JsonManagedReference
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "App_user_role",
            joinColumns = { @JoinColumn(name = "app_user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    @JsonManagedReference
    private Set<Role> roles = new HashSet<>();


}
