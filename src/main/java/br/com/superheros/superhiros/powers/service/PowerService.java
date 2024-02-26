package br.com.superheros.superhiros.powers.service;

import br.com.superheros.superhiros.powers.application.PowerDetailResponse;
import br.com.superheros.superhiros.powers.application.PowerResponse;
import br.com.superheros.superhiros.powers.dto.PowerDTO;

import java.util.UUID;

public interface PowerService {
    PowerResponse createPower(UUID idHeros, PowerDTO powerDTO);
    PowerDetailResponse getPowerById(UUID idPower);
}
