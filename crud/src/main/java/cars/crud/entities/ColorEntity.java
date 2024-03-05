package cars.crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "cor")
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cor", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome_cor", nullable = false)
    private String name;

}
