package main.java.com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import main.java.com.mcb.creditfactory.external.CollateralType;
import main.java.com.mcb.creditfactory.service.collateral.GetInfoCollateralObj;
import main.java.com.mcb.creditfactory.service.collateral.AddCollateralObj;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDto.class),
        @JsonSubTypes.Type(value = AirplaneDto.class)
})
public interface Collateral {
    Long applyAdd(AddCollateralObj object);
    Collateral applyGetInfo(GetInfoCollateralObj object);
    CollateralType getType();
}
