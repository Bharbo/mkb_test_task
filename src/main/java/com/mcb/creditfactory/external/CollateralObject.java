package main.java.com.mcb.creditfactory.external;

import main.java.com.mcb.creditfactory.model.Price;
import java.time.LocalDate;

public interface CollateralObject {
    Price getPrice();
    Short getYear();
    LocalDate getDate();
    CollateralType getType();
}
