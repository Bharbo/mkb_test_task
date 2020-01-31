package main.java.com.mcb.creditfactory.service.collateral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.mcb.creditfactory.dto.AirplaneDto;
import main.java.com.mcb.creditfactory.dto.CarDto;
import main.java.com.mcb.creditfactory.dto.Collateral;
import main.java.com.mcb.creditfactory.service.airplane.AirplaneService;
import main.java.com.mcb.creditfactory.service.car.CarService;
import java.util.Optional;

@Service
public class CollateralService {

    public CarService carService;
    public AirplaneService airplaneService;

    @Autowired
    public CollateralService(CarService carService, AirplaneService airplaneService) {
        this.carService = carService;
        this.airplaneService = airplaneService;
    }

    private AddCollateralObj addObject
            = new AddCollateralObj(this);
    private GetInfoCollateralObj getInfoObject
            = new GetInfoCollateralObj(this);




    public Long addCollateral(CarDto car) {
        boolean approved = carService.approve(car);
        if (!approved) {
            return null;
        }
        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::add)
                .map(carService::getId)
                .orElse(null);
    }

    public Collateral getInfoCollateral(CarDto car) {
        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::getId)
                .flatMap(carService::findById)
                .map(carService::toDTO)
                .orElse(null);
    }



    public Long addCollateral(AirplaneDto airplaneDto) {
        boolean approved = airplaneService.approve(airplaneDto);
        if (!approved) {
            return null;
        }
        return Optional.of(airplaneDto)
                .map(airplaneService::fromDto)
                .map(airplaneService::add)
                .map(airplaneService::getId)
                .orElse(null);
    }

    public Collateral getInfoCollateral(AirplaneDto airplaneDto) {
        return Optional.of(airplaneDto)
                .map(airplaneService::fromDto)
                .map(airplaneService::getId)
                .flatMap(airplaneService::findById)
                .map(airplaneService::toDTO)
                .orElse(null);
    }



    public Long addCollateral(Collateral collateral) {
        return collateral.applyAdd(addObject);
    }
    public Collateral getInfoCollateral(Collateral collateral) {
        return collateral.applyGetInfo(getInfoObject);
    }
}
