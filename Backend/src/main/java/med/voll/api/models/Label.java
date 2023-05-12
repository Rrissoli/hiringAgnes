package med.voll.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Label")
@Table(name = "label")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
public class Label extends WithTimestamp{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String color;

    @ManyToOne
    @JsonIgnore
    private Project project;

}
