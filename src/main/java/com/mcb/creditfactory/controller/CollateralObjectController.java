package main.java.com.mcb.creditfactory.controller;

import main.java.com.mcb.creditfactory.dto.Collateral;
import main.java.com.mcb.creditfactory.service.collateral.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollateralObjectController {

    @Autowired
    private CollateralService collateralService;

    @PostMapping("/collateral/add")
    public HttpEntity<Long> add(@RequestBody Collateral object) {
        Long id = collateralService.addCollateral(object);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/collateral/info")
    public HttpEntity<Collateral> getInfo(@RequestBody Collateral object) {
        Collateral info = collateralService.getInfoCollateral(object);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }
}
