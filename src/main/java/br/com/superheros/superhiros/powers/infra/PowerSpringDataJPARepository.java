package br.com.superheros.superhiros.powers.infra;

import br.com.superheros.superhiros.powers.model.PowerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PowerSpringDataJPARepository extends JpaRepository<PowerModel, UUID> {
}
