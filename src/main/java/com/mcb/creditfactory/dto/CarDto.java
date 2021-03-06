package main.java.com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.java.com.mcb.creditfactory.external.CollateralType;
import main.java.com.mcb.creditfactory.service.collateral.GetInfoCollateralObj;
import main.java.com.mcb.creditfactory.service.collateral.AddCollateralObj;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("car")
public class CarDto implements Collateral {
    private Long    id;
    private String  brand;
    private String  model;
    private Double  power;
    private Short   year;

    @Override
    public Long applyAdd(AddCollateralObj object) {
        return object.object(this);
    }

    @Override
    public Collateral applyGetInfo(GetInfoCollateralObj object) {
        return object.object(this);
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
