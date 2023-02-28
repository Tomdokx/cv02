package NNPIA.cv01;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Task")
public class Task {
    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDate creation_date;
    @Column
    private LocalDate update_date;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    @JsonBackReference
    private AppUser author_id;


}
