package br.com.superheros.superhiros.heros.service;

import br.com.superheros.superhiros.heros.application.HerosDetailResponse;
import br.com.superheros.superhiros.heros.application.HerosListResponse;
import br.com.superheros.superhiros.heros.application.HerosResponse;
import br.com.superheros.superhiros.heros.dto.HerosDTO;

import java.util.List;
import java.util.UUID;

public interface HerosService {
    HerosResponse createHero(HerosDTO herosDTO);
    HerosDetailResponse getHerosById(UUID idHeros);
    List<HerosListResponse> getAll();
    void deleteHerosById(UUID idHeros);
    void updateHeroById(UUID idHeros, HerosDTO herosDTO);
}
