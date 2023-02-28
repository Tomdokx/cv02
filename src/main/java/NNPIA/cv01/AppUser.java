package NNPIA.cv01;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
* none, validate, update, create-drop
* */
@Getter
@Setter
@Entity
@ToString
@Table(name="AppUser")
public class AppUser {

    @Id
    private int id;
    @Column
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
