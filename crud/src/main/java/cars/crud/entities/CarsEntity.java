package cars.crud.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name = "cars")
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car", nullable = false, unique = true)
    private Long id;

    @Column(name = "name_car", nullable = false)
    private String name;

    @Column(name = "year_manufacturing", nullable = false)
    private Integer yearManufacture;

    @Column(name = "year_model", nullable = false)
    private Integer yearModel;

    @Column(name = "model", nullable = false)
    private String model;

    @OneToOne
    @JoinColumn(name = "make_id")
    private  MakeEntity make;

    @ManyToMany
    @JoinTable(
            name = "car_color",
            joinColumns = @JoinColumn(name = "id_car"),
            inverseJoinColumns = @JoinColumn(name = "id_color")
    )
    private List<ColorEntity> colors;
}
