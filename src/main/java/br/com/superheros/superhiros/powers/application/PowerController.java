package br.com.superheros.superhiros.powers.application;

import br.com.superheros.superhiros.powers.dto.PowerDTO;
import br.com.superheros.superhiros.powers.service.PowerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Log4j2
@RequestMapping("/heros/{idHeros}/power")
@RequiredArgsConstructor
public class PowerController {
    private final PowerService powerService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PowerResponse createPower(@PathVariable UUID idHeros, @Valid @RequestBody PowerDTO powerDTO){
        log.info("[start] PowerController - createPower");
        log.info("[idHeros] {}", idHeros);
        PowerResponse powerCreate = powerService.createPower(idHeros, powerDTO);
        log.info("[finish] PowerController - createPower");
        return powerCreate;
    }
    @GetMapping(value = "/{idPower}")
    @ResponseStatus(code = HttpStatus.OK)
    PowerDetailResponse getPowerById(@PathVariable UUID idPower){
        log.info("[start] PowerController - getPowerById");
        log.info("[idPower] {}", idPower);
        PowerDetailResponse powerStatus = powerService.getPowerById(idPower);
        log.info("[finish] PowerController - getPowerById");
        return powerStatus;
    }
    @DeleteMapping(value = "/{idPower}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePowerById(@PathVariable UUID idHeros, @PathVariable UUID idPower){
        log.info("[start] PowerController - deletePowerById");
        log.info("[idHeros] {} - [idPower] {}", idHeros, idPower);
        powerService.deletePowerById(idHeros, idPower);
        log.info("[finish] PowerController - deletePowerById");
    }
    @PutMapping(value = "/{idPower}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updatePower(@PathVariable UUID idPower, @Valid @RequestBody PowerUpDate powerUpDate){
        log.info("[start] PowerController - updatePower");
        log.info("[idPower] {}", idPower);
        powerService.upDatePowerById(idPower, powerUpDate);
        log.info("[finish] PowerController - updatePower");
    }

}
