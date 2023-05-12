package med.voll.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dtos.ProjectDTOS.CreateProjectDTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "Project")
@Table(name = "projects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    private boolean terminated ;
    private String background;
    @Builder.Default
    private String hash = UUID.randomUUID().toString();

    @ManyToOne
    @JsonIgnore
    private Client client;

    private Date createdAt;

    private Date updatedAt;
    @OneToMany(mappedBy = "project")
    private List<Activities_list> activitiesLists;

    public Project(CreateProjectDTO create, Client client) {
        this.name = create.getName();
        this.terminated = false;
        this.background = create.getBackground();
        this.client = client;
        this.createdAt = new Date();

    }


}
