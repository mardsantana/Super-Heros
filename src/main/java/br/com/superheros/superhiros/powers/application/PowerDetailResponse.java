package br.com.superheros.superhiros.powers.application;

import br.com.superheros.superhiros.heros.model.HerosModel;
import br.com.superheros.superhiros.powers.model.PowerModel;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class PowerDetailResponse {
    private UUID idHeros;
    private String descriptionOfPower;
    private String weakness;
    private LocalDateTime hourOfRegister;

    public PowerDetailResponse(PowerModel powerModel) {
        this.idHeros = powerModel.getIdHeros();
        this.descriptionOfPower = powerModel.getDescriptionOfPower();
        this.weakness = powerModel.getWeakness();
        this.hourOfRegister = LocalDateTime.now();
    }
}
