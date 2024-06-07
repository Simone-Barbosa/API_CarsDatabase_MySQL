package cars.crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "color")
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_color", nullable = false, unique = true)
    private Long id;

    @Column(name = "name_color", nullable = false)
    private String name;

}
