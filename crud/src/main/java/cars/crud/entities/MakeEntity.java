package cars.crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "make")
public class MakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_make", nullable = false, unique = true)
    private Long id;

    @Column(name = "name_make", nullable = false)
    private String name;
}
