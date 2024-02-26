package br.com.superheros.superhiros.powers.dto;

import br.com.superheros.superhiros.heros.model.HerosModel;
import br.com.superheros.superhiros.powers.model.PowerModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class PowerDTO {
    @NotBlank
    @Column(table = "description_of_power", columnDefinition = "TEXT")
    private String descriptionOfPower;
    @NotBlank
    private String weakness;
    @Column(table = "hour_of_register")
    private LocalDateTime hourOfRegister;
    private Map<String, Double> powerPercentages;

    public PowerDTO() {
    }

    public PowerDTO(PowerDTO powerDTO) {
        this.descriptionOfPower = powerDTO.getDescriptionOfPower();
        this.weakness = powerDTO.getWeakness();
        this.hourOfRegister = powerDTO.getHourOfRegister();
    }

    public PowerDTO(PowerModel powerModel) {
        this.descriptionOfPower = powerModel.getDescriptionOfPower();
        this.weakness = powerModel.getWeakness();
        this.hourOfRegister = LocalDateTime.now();
        this.powerPercentages = powerModel.calculatePowerPorcentages();

    }
}
