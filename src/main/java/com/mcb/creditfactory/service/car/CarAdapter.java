package main.java.com.mcb.creditfactory.service.car;

import main.java.com.mcb.creditfactory.dto.CarDto;
import main.java.com.mcb.creditfactory.external.CollateralObject;
import main.java.com.mcb.creditfactory.external.CollateralType;
import main.java.com.mcb.creditfactory.model.Price;
import main.java.com.mcb.creditfactory.repository.PriceRepository;
import main.java.com.mcb.creditfactory.service.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.Optional;

public class CarAdapter implements CollateralObject {

    private CarDto carDto;
    private PriceService priceService;
    private PriceRepository priceRepository;

    @Autowired
    public CarAdapter(PriceService priceService, PriceRepository priceRepository){
        this.priceService = priceService;
        this.priceRepository = priceRepository;
    }

    public CarAdapter(CarDto carDto) {
        this.carDto = carDto;
    }

    @Override
    public LocalDate getDate() {
        return priceRepository.findLastDate();
    }

    @Override
    public Short getYear() {
        return carDto.getYear();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }

    @Override
    public Price getPrice() {
        return Optional.of(priceService.getLast(carDto.getId(), CollateralType.CAR))
                .orElse(null);
    }
}
