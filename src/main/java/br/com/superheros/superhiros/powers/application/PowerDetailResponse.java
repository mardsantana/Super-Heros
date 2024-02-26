package br.com.superheros.superhiros.powers.application;

import br.com.superheros.superhiros.powers.model.PowerModel;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Value
public class PowerDetailResponse {
    private UUID idPower;
    private UUID idHeros;
    private String descriptionOfPower;
    private String weakness;
    private LocalDateTime hourOfRegister;
    private Map<String, Double> powerPercentages;

    public PowerDetailResponse(PowerModel powerModel, Map<String, Double> powerPercentages) {
        this.idPower = powerModel.getIdPower();
        this.idHeros = powerModel.getIdHeros();
        this.descriptionOfPower = powerModel.getDescriptionOfPower();
        this.weakness = powerModel.getWeakness();
        this.hourOfRegister = LocalDateTime.now();
        this.powerPercentages = powerPercentages;
    }
}
