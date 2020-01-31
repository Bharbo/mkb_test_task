package main.java.com.mcb.creditfactory.repository;

import main.java.com.mcb.creditfactory.external.CollateralType;
import main.java.com.mcb.creditfactory.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {

    List<Price> findByCollateralIdAndCollateralType(Long collateralId, CollateralType collateralType);

    @Query(value = "SELECT date FROM price " +
            "ORDER BY date DESC LIMIT 1", nativeQuery = true)
    LocalDate findLastDate();

    @Query(value = "SELECT * FROM price " +
            "WHERE object_id=?1 AND object_type=?2 " +
            "ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Price findLastByCollateralIdAndCollateralType(Long collateralId, CollateralType collateralType);
}
