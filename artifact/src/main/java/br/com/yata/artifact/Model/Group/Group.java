package br.com.yata.artifact.Model.Group;

import br.com.yata.artifact.Model.Task.Task;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "groups")
    private Set<Task> tasks = new HashSet<>();
}
