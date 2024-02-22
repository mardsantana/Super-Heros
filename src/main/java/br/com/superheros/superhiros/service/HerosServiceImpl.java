package br.com.superheros.superhiros.service;

import br.com.superheros.superhiros.application.HerosResponse;
import br.com.superheros.superhiros.dto.HerosDTO;
import br.com.superheros.superhiros.model.HerosModel;
import br.com.superheros.superhiros.repository.HerosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
