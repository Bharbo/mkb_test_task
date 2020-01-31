package main.java.com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  brand;
    private String  model;
    private String  manufacturer;
    private Integer fuelCapacity;
    private Integer seats;

    @Column(name = "year_of_issue")
    private Short   year;
}
