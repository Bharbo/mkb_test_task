package main.java.com.mcb.creditfactory.model;

import main.java.com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long            id;
    private BigDecimal      price;
    private LocalDate       date;

    @Column(name = "object_id")
    private Long            collateralId;
    @Column(name = "object_type")
    private CollateralType  collateralType;
}
