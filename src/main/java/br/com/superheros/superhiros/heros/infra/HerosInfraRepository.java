package br.com.superheros.superhiros.heros.infra;

import br.com.superheros.superhiros.handler.APIException;
import br.com.superheros.superhiros.heros.model.HerosModel;
import br.com.superheros.superhiros.heros.repository.HerosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class HerosInfraRepository implements HerosRepository {
    private final HerosSpringDataJPARepository herosSpringDataJPARepository;
    @Override
    public HerosModel save(HerosModel herosModel) {
        log.info("[start] HerosInfraRepository - save");
        herosSpringDataJPARepository.save(herosModel);
        log.info("[finish] HerosInfraRepository - save");
        return herosModel;
    }
    @Override
    public HerosModel getHerosById(UUID idHeros) {
        log.info("[start] HerosInfraRepository - getHerosById");
        HerosModel herosModel = herosSpringDataJPARepository.findById(idHeros)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Heros Not Found!!!"));
        log.info("[finish] HerosInfraRepository - getHerosById");
        return herosModel;
    }
    @Override
    public List<HerosModel> getAll() {
        log.info("[start] HerosInfraRepository - getAll");
        List<HerosModel> generateHeros = herosSpringDataJPARepository.findAll();
        log.info("[finish] HerosInfraRepository - getAll");
        return generateHeros;
    }
    @Override
    public void deleteHero(HerosModel herosModel) {
        log.info("[start] HerosInfraRepository - deleteHero");
        herosSpringDataJPARepository.delete(herosModel);
        log.info("[finish] HerosInfraRepository - deleteHero");
    }
}
