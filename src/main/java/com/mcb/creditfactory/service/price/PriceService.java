package main.java.com.mcb.creditfactory.service.price;

import java.util.List;
import java.util.Optional;
import main.java.com.mcb.creditfactory.external.CollateralType;
import main.java.com.mcb.creditfactory.model.Price;
import main.java.com.mcb.creditfactory.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Long add(Price price) {
        return Optional.of(priceRepository.save(price))
                .map(Price::getId)
                .orElse(null);
    }

    public List<Price> getList(Long collateralId, CollateralType collateralType) {
        return priceRepository.findByCollateralIdAndCollateralType(collateralId, collateralType);
    }

    public Price getLast(Long collateralId, CollateralType collateralType) {
        return priceRepository.findLastByCollateralIdAndCollateralType(collateralId, collateralType);
    }
}
