package br.com.superheros.superhiros.service;

import br.com.superheros.superhiros.application.HerosDetailResponse;
import br.com.superheros.superhiros.application.HerosListDTO;
import br.com.superheros.superhiros.application.HerosResponse;
import br.com.superheros.superhiros.dto.HerosDTO;
import br.com.superheros.superhiros.model.HerosModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface HerosService {
    HerosResponse createHero(HerosDTO herosDTO);
    HerosDetailResponse getHerosById(UUID idHeros);
    List<HerosListDTO> getAll();
    void deleteHerosById(UUID idHeros);
    void updateHeroById(UUID idHeros, HerosDTO herosDTO);
}
