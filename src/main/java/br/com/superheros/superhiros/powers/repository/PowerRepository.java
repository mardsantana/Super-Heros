package br.com.superheros.superhiros.powers.repository;

import br.com.superheros.superhiros.powers.model.PowerModel;

import java.util.UUID;

public interface PowerRepository {
    PowerModel savePower(PowerModel powerModel);
    PowerModel getPowerById(UUID idPower);
    void deletePower(PowerModel powerModel);
}
