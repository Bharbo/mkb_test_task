package main.java.com.mcb.creditfactory.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import main.java.com.mcb.creditfactory.external.CollateralType;
import main.java.com.mcb.creditfactory.model.Price;
import main.java.com.mcb.creditfactory.service.price.PriceService;
import java.util.List;

@RestController
public class PriceController {

    @Autowired
    private PriceService priceService;

    @PostMapping("/collateral/price/add")
    public HttpEntity<Long> add(@RequestBody Price price) {
        Long id = priceService.add(price);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/collateral/price/{objectId}")
    public HttpEntity<List<Price>> getList(@RequestBody Long objectId, CollateralType collateralType) {
        List<Price> priceList = priceService.getList(objectId, collateralType);
        return priceList != null ? ResponseEntity.ok(priceList) : ResponseEntity.notFound().build();
    }

    @PostMapping("/collateral/price/{objectId}/actual/")
    public HttpEntity<Price> getLast(@RequestBody Long objectId, CollateralType collateralType) {
        Price price = priceService.getLast(objectId, collateralType);
        return price != null ? ResponseEntity.ok(price) : ResponseEntity.notFound().build();
    }
}
