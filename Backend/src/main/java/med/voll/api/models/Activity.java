package med.voll.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dtos.Activity.CreateActivityDTO;
import med.voll.api.enums.Status;

import java.util.Date;

@Data
@Entity(name = "Activity")
@Table(name = "activity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    private String description;
    private Status status;

    private String start_date;
    private String dae_date;

    private int show_order;
    private boolean backlog;
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne
    @JsonIgnore
    private Activities_list activities_list;

    public Activity(CreateActivityDTO createActivityDTO, Activities_list activities_list){
        this.title = createActivityDTO.getTitle();
        this.description = createActivityDTO.getDescription();
        this.status = createActivityDTO.getStatus();
        this.start_date = createActivityDTO.getStart_date();
        this.dae_date = createActivityDTO.getDae_date();
        this.show_order = createActivityDTO.getShow_order();
        this.backlog = false;
        this.createdAt = new Date();
        this.activities_list = activities_list;

    }

}
