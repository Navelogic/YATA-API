package br.com.yata.artifact.Model.Category;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Category")
@Table(name = "categories")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}
