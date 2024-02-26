package br.com.superheros.superhiros.powers.service;

import br.com.superheros.superhiros.heros.service.HerosService;
import br.com.superheros.superhiros.powers.application.PowerDetailResponse;
import br.com.superheros.superhiros.powers.application.PowerResponse;
import br.com.superheros.superhiros.powers.application.PowerUpDate;
import br.com.superheros.superhiros.powers.dto.PowerDTO;
import br.com.superheros.superhiros.powers.model.PowerModel;
import br.com.superheros.superhiros.powers.repository.PowerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PowerServiceImpl implements PowerService{
    private final PowerRepository powerRepository;
    private final HerosService herosService;

    @Override
    public PowerResponse createPower(UUID idHeros, PowerDTO powerDTO) {
        log.info("[start] PowerServiceImpl - createPower");
        herosService.getHerosById(idHeros);
        PowerModel powerModel = powerRepository.savePower(new PowerModel(idHeros, powerDTO));
        log.info("[finish] PowerServiceImpl - createPower");
        return new PowerResponse(powerModel.getIdPower());
    }
    @Override
    public PowerDetailResponse getPowerById(UUID idPower) {
        log.info("[start] PowerServiceImpl - getPowerById");
        PowerModel powerModel = powerRepository.getPowerById(idPower);
        if (powerModel != null){
            Map<String, Double> powerPorcentages = powerModel.calculatePowerPorcentages();
            log.info("Power percentages for power with ID {}: {}", idPower, powerPorcentages);
            log.info("[finish] PowerServiceImpl - getPowerById");
            return new PowerDetailResponse(powerModel, powerPorcentages);
        }
        log.info("[finish] PowerServiceImpl - getPowerById");
        return null;
        }
    @Override
    public void deletePowerById(UUID idHeros, UUID idPower) {
        log.info("[start] PowerServiceImpl - deletePowerById");
        herosService.getHerosById(idHeros);
        PowerModel powerModel = powerRepository.getPowerById(idPower);
        powerRepository.deletePower(powerModel);
        log.info("[finish] PowerServiceImpl - deletePowerById");
    }

    @Override
    public void upDatePowerById(UUID idPower, PowerUpDate powerUpDate) {
        log.info("[start] PowerServiceImpl - upDatePowerById");
        PowerModel powerModel = powerRepository.getPowerById(idPower);
        powerModel.upDate(powerUpDate);
        powerRepository.savePower(powerModel);
        log.info("[finish] PowerServiceImpl - upDatePowerById");
    }
}
