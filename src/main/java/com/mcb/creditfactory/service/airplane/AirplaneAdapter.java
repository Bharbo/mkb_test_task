package main.java.com.mcb.creditfactory.service.airplane;

import main.java.com.mcb.creditfactory.dto.AirplaneDto;
import main.java.com.mcb.creditfactory.external.CollateralObject;
import main.java.com.mcb.creditfactory.external.CollateralType;
import main.java.com.mcb.creditfactory.model.Price;
import main.java.com.mcb.creditfactory.repository.PriceRepository;
import main.java.com.mcb.creditfactory.service.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.Optional;

public class AirplaneAdapter implements CollateralObject {

    private PriceService priceService;
    private PriceRepository priceRepository;
    private AirplaneDto airplane;

    @Autowired
    public AirplaneAdapter(PriceService priceService, PriceRepository priceRepository) {
        this.priceService = priceService;
        this.priceRepository = priceRepository;
    }

    public AirplaneAdapter(AirplaneDto airplane) {
        this.airplane = airplane;
    }

    @Override
    public Short getYear() {
        return airplane.getYear();
    }

    @Override
    public LocalDate getDate() {
        return priceRepository.findLastDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }

    @Override
    public Price getPrice() {
        return Optional.of(priceService.getLast(airplane.getId(), CollateralType.AIRPLANE))
                .orElse(null);
    }
}
