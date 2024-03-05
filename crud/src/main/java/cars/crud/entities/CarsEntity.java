package cars.crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "carro")
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome_carro", nullable = false)
    private String name;

    @Column(name = "ano_fabricacao_carro", nullable = false)
    private Integer yearManufacture;

    @Column(name = "ano_modelo_carro", nullable = false)
    private Integer yearModel;

    @Column(name = "modelo_carro", nullable = false)
    private String model;

    @OneToOne
    @JoinColumn
    private  MakeEntity marca; // tem quer coincidir com: @Entity(name = "marca")

    @ManyToMany
    @JoinTable(
            name = "carro_cor",
            joinColumns = @JoinColumn(name = "id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_cor")
    )
    private List<ColorEntity> colors;
}
