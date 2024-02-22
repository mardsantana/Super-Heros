package br.com.superheros.superhiros.service;

import br.com.superheros.superhiros.application.HerosDetailResponse;
import br.com.superheros.superhiros.application.HerosListDTO;
import br.com.superheros.superhiros.application.HerosResponse;
import br.com.superheros.superhiros.dto.HerosDTO;
import br.com.superheros.superhiros.model.HerosModel;
import br.com.superheros.superhiros.repository.HerosRepository;
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
    public List<HerosListDTO> getAll() {
        log.info("[start] HerosServiceImpl - getAll");
        List<HerosModel> herosModels = herosRepository.getAll();
        log.info("[finish] HerosServiceImpl - getAll");
        return HerosListDTO.Converte(herosModels);
    }
    @Override
    public void deleteHerosById(UUID idHeros) {
        log.info("[start] HerosServiceImpl - deleteHerosById");
        HerosModel herosModel = herosRepository.getHerosById(idHeros);
        herosRepository.deleteHero(herosModel);
        log.info("[finish] HerosServiceImpl - deleteHerosById");
    }
}
