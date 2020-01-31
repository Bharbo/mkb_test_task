package main.java.com.mcb.creditfactory.service.car;

import main.java.com.mcb.creditfactory.dto.CarDto;
import main.java.com.mcb.creditfactory.model.Car;
import java.util.Optional;

public interface CarService {
    boolean approve(CarDto dto);
    Car add(Car car);
    Optional<Car> findById(Long id);
    Car fromDto(CarDto dto);
    CarDto toDTO(Car car);
    Long getId(Car car);
}
