package br.com.superheros.superhiros.powers.infra;

import br.com.superheros.superhiros.handler.APIException;
import br.com.superheros.superhiros.powers.model.PowerModel;
import br.com.superheros.superhiros.powers.repository.PowerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PowerInfraRepository implements PowerRepository {
    private final PowerSpringDataJPARepository powerSpringDataJPARepository;
    @Override
    public PowerModel savePower(PowerModel powerModel) {
        log.info("[start] PowerInfraRepository - savePower");
        powerSpringDataJPARepository.save(powerModel);
        log.info("[finish] PowerInfraRepository - savePower");
        return powerModel;
    }
    @Override
    public PowerModel getPowerById(UUID idPower) {
        log.info("[start] PowerInfraRepository - getPowerById");
        var power = powerSpringDataJPARepository.findById(idPower)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Power Not Found!!"));
        log.info("[finish] PowerInfraRepository - getPowerById");
        return power;
    }
    @Override
    public void deletePower(PowerModel powerModel) {
        log.info("[start] PowerInfraRepository - deletePower");
        powerSpringDataJPARepository.delete(powerModel);
        log.info("[finish] PowerInfraRepository - deletePower");
    }
}
