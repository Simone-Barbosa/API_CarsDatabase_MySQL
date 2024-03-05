package cars.crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "marca")
public class MakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome_marca", nullable = false)
    private String name;
}
