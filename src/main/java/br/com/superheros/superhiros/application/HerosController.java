package br.com.superheros.superhiros.application;

import br.com.superheros.superhiros.dto.HerosDTO;
import br.com.superheros.superhiros.model.HerosModel;
import br.com.superheros.superhiros.service.HerosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    @GetMapping(value = "/{idHeros}")
    @ResponseStatus(code = HttpStatus.OK)
    HerosDetailResponse getHerosById(@PathVariable UUID idHeros){
        log.info("[start] HerosController - getHerosById");
        log.info("[idHeros] {}", idHeros);
        HerosDetailResponse herosDetail = herosService.getHerosById(idHeros);
        log.info("[finish] HerosController - getHerosById");
        return herosDetail;
    }
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<HerosListDTO> getGenerateHeros(){
        log.info("[start] HerosController - getGenerateHeros");
        List<HerosListDTO> heros = herosService.getAll();
        log.info("[finish] HerosController - getGenerateHeros");
        return heros;
    }
    @DeleteMapping(value = "/{idHeros}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable UUID idHeros){
        log.info("[start] HerosController - deleteById");
        log.info("[idHeros] {}", idHeros);
        herosService.deleteHerosById(idHeros);
        log.info("[finish] HerosController - deleteById");
    }
    @PutMapping(value = "/{idHeros}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void updateHeroById(@PathVariable UUID idHeros, @Valid @RequestBody HerosDTO herosDTO){
        log.info("[start] HerosController - updateHeroById");
        log.info("[idHeros] {}", idHeros);
        herosService.updateHeroById(idHeros, herosDTO);
        log.info("[finish] HerosController - updateHeroById");
    }

}
