package main.java.com.mcb.creditfactory.service.collateral;

import main.java.com.mcb.creditfactory.dto.AirplaneDto;
import main.java.com.mcb.creditfactory.dto.CarDto;
import main.java.com.mcb.creditfactory.dto.Collateral;

public class GetInfoCollateralObj implements CollateralObj {

    private CollateralService service;

    public GetInfoCollateralObj(CollateralService service){
        this.service = service;
    }

    public Collateral object(CarDto carDto) {
        return service.getInfoCollateral(carDto);
    }
    public Collateral object(AirplaneDto airplaneDto) {
        return service.getInfoCollateral(airplaneDto);
    }
}
