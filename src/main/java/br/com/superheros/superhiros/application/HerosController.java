package br.com.superheros.superhiros.application;

import br.com.superheros.superhiros.dto.HerosDTO;
import br.com.superheros.superhiros.model.HerosModel;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class HerosController {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<HerosModel> createHero(@RequestBody @Valid HerosDTO herosDTO){
        log.info("[start] HerosController - createHero");

        log.info("[finish] HerosController - createHero");
    }
}
