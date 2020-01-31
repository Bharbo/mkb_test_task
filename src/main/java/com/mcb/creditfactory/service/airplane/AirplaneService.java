package main.java.com.mcb.creditfactory.service.airplane;

import main.java.com.mcb.creditfactory.dto.AirplaneDto;
import main.java.com.mcb.creditfactory.model.Airplane;
import java.util.Optional;

public interface AirplaneService {
    boolean approve(AirplaneDto dto);
    Airplane add(Airplane airplane);
    Optional<Airplane> findById(Long id);
    Airplane fromDto(AirplaneDto dto);
    AirplaneDto toDTO(Airplane airplane);
    Long getId(Airplane airplane);
}
