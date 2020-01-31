package main.java.com.mcb.creditfactory.repository;

import main.java.com.mcb.creditfactory.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
