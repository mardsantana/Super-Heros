package br.com.superheros.superhiros.service;

import br.com.superheros.superhiros.application.HerosResponse;
import br.com.superheros.superhiros.dto.HerosDTO;
import br.com.superheros.superhiros.model.HerosModel;
import org.springframework.http.ResponseEntity;

public interface HerosService {
    HerosResponse createHero(HerosDTO herosDTO);
}
