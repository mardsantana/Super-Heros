package br.com.superheros.superhiros.heros.service;

import br.com.superheros.superhiros.heros.application.HerosDetailResponse;
import br.com.superheros.superhiros.heros.application.HerosListResponse;
import br.com.superheros.superhiros.heros.application.HerosResponse;
import br.com.superheros.superhiros.heros.dto.HerosDTO;
import br.com.superheros.superhiros.heros.model.HerosModel;
import br.com.superheros.superhiros.heros.repository.HerosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class HerosServiceImpl implements HerosService{
    private final HerosRepository herosRepository;
    @Override
    public HerosResponse createHero(HerosDTO herosDTO) {
        log.info("[start] HerosServiceImpl - createHero");
        HerosModel herosModel = herosRepository.save(new HerosModel(herosDTO));
        log.info("[finish] HerosServiceImpl - createHero");
        return new HerosResponse(herosModel);
    }
    @Override
    public HerosDetailResponse getHerosById(UUID idHeros) {
        log.info("[start] HerosServiceImpl - getHerosById");
        HerosModel herosModel = herosRepository.getHerosById(idHeros);
        log.info("[start] HerosServiceImpl - getHerosById");
        return new HerosDetailResponse(herosModel);
    }
    @Override
    public List<HerosListResponse> getAll() {
        log.info("[start] HerosServiceImpl - getAll");
        List<HerosModel> herosModels = herosRepository.getAll();
        log.info("[finish] HerosServiceImpl - getAll");
        return HerosListResponse.Converte(herosModels);
    }
    @Override
    public void deleteHerosById(UUID idHeros) {
        log.info("[start] HerosServiceImpl - deleteHerosById");
        HerosModel herosModel = herosRepository.getHerosById(idHeros);
        herosRepository.deleteHero(herosModel);
        log.info("[finish] HerosServiceImpl - deleteHerosById");
    }
    @Override
    public void updateHeroById(UUID idHeros, HerosDTO herosDTO) {
        log.info("[start] HerosServiceImpl - updateHeroById");
        HerosModel herosModel = herosRepository.getHerosById(idHeros);
        herosModel.update(herosDTO);
        herosRepository.save(herosModel);
        log.info("[finish] HerosServiceImpl - updateHeroById");
    }
}
