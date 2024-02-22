package br.com.superheros.superhiros.infra;

import br.com.superheros.superhiros.repository.HerosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class HerosInfraRepository implements HerosRepository {
}
