package main.java.com.mcb.creditfactory.service.car;

import main.java.com.mcb.creditfactory.dto.CarDto;
import main.java.com.mcb.creditfactory.external.ExternalApproveService;
import main.java.com.mcb.creditfactory.model.Car;
import main.java.com.mcb.creditfactory.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private ExternalApproveService approveService;
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(ExternalApproveService approveService, CarRepository carRepository) {
        this.approveService = approveService;
        this.carRepository = carRepository;
    }

    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto)) == 0;
    }

    @Override
    public Car add(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto)
    {
        return new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear()
        );
    }

    @Override
    public CarDto toDTO(Car car)
    {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear()
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }
}
