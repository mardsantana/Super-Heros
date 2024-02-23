package br.com.superheros.superhiros.powers.service;

import br.com.superheros.superhiros.heros.service.HerosService;
import br.com.superheros.superhiros.powers.application.PowerResponse;
import br.com.superheros.superhiros.powers.dto.PowerDTO;
import br.com.superheros.superhiros.powers.model.PowerModel;
import br.com.superheros.superhiros.powers.repository.PowerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
