package br.com.superheros.superhiros.infra;

import br.com.superheros.superhiros.model.HerosModel;
import br.com.superheros.superhiros.repository.HerosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
