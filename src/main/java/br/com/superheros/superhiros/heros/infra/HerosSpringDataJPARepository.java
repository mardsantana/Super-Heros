package br.com.superheros.superhiros.heros.infra;

import br.com.superheros.superhiros.heros.model.HerosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HerosSpringDataJPARepository extends JpaRepository<HerosModel, UUID> {
}
