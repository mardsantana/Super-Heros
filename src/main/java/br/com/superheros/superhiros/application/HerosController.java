package br.com.superheros.superhiros.application;

import br.com.superheros.superhiros.dto.HerosDTO;
import br.com.superheros.superhiros.model.HerosModel;
import br.com.superheros.superhiros.service.HerosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/heros")
@RequiredArgsConstructor
public class HerosController {

    private final HerosService herosService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    HerosResponse createHero(@RequestBody @Valid HerosDTO herosDTO){
        log.info("[start] HerosController - createHero");
        HerosResponse herosCreate = herosService.createHero(herosDTO);
        log.info("[finish] HerosController - createHero");
        return herosCreate;
    }

}
