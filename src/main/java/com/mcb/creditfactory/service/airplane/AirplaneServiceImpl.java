package main.java.com.mcb.creditfactory.service.airplane;

import main.java.com.mcb.creditfactory.dto.AirplaneDto;
import main.java.com.mcb.creditfactory.external.ExternalApproveService;
import main.java.com.mcb.creditfactory.model.Airplane;
import main.java.com.mcb.creditfactory.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private ExternalApproveService approveService;
    private AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneServiceImpl(ExternalApproveService approveService, AirplaneRepository airplaneRepository) {
        this.approveService = approveService;
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public boolean approve(AirplaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane add(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> findById(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto)
    {
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getFuelCapacity(),
                dto.getSeats(),
                dto.getYear()
        );
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane)
    {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getFuelCapacity(),
                airplane.getSeats(),
                airplane.getYear()
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}
