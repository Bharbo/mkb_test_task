package main.java.com.mcb.creditfactory.repository;

import main.java.com.mcb.creditfactory.model.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}
