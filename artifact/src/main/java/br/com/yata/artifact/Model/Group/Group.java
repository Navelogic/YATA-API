package br.com.yata.artifact.Model.Group;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Group")
@Table(name = "groups")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String status;
}
