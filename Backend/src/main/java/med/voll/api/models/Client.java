package med.voll.api.models;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.dtos.ClientDTOS.CreateClientDTO;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Client")
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String bio;
    @OneToMany(mappedBy = "client")
    private List<Project> projects;

    private Date createdAt;

    private Date updatedAt;
    public Client(CreateClientDTO clientDto){
        this.name =clientDto.getName();
        this.createdAt = new Date();
    }


}
