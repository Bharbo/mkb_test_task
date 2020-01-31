package main.java.com.mcb.creditfactory.service.collateral;

import main.java.com.mcb.creditfactory.dto.AirplaneDto;
import main.java.com.mcb.creditfactory.dto.CarDto;

public class AddCollateralObj implements CollateralObj {

    private CollateralService service;

    public AddCollateralObj(CollateralService service){
        this.service = service;
    }

    public Long object(CarDto carDto) {
        return service.addCollateral(carDto);
    }
    public Long object(AirplaneDto airplaneDto) {
        return service.addCollateral(airplaneDto);
    }
}
