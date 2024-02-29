package br.com.superheros.superhiros.powers.model;

import br.com.superheros.superhiros.heros.model.HerosModel;
import br.com.superheros.superhiros.powers.application.PowerUpDate;
import br.com.superheros.superhiros.powers.dto.PowerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Table(name = "Powers")
public class PowerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idPower", updatable = false, unique = true, nullable = false)
    private UUID idPower;
    @NotNull
    @Column(columnDefinition = "uuid", name = "idHeros", nullable = false)
    private UUID idHeros;
    private String descriptionOfPower;
    private String weakness;
    private LocalDateTime hourOfRegister;
    @ManyToOne
    private HerosModel hero;


    public PowerModel() {
    }

    public PowerModel(UUID idHeros, PowerDTO powerDTO) {
        this.idHeros = idHeros;
        this.descriptionOfPower = powerDTO.getDescriptionOfPower();
        this.weakness = powerDTO.getWeakness();
    }

    public PowerModel(PowerModel powerModel) {
        this.idHeros = powerModel.getIdHeros();
        this.descriptionOfPower = powerModel.getDescriptionOfPower();
        this.weakness = powerModel.getWeakness();
    }

    public void upDate(PowerUpDate powerUpDate) {
        this.descriptionOfPower = powerUpDate.getDescriptionOfPower();
        this.weakness = powerUpDate.getWeakness();
    }

    public Map<String, Double> calculatePowerPorcentages() {
        Map<String, Double> powerPorcentages = new HashMap<>();
        double total = getTotalPower();

        double powerPorcentage = (double) descriptionOfPower.length() / total * 100;
        double weaknessPorcentage = (double) weakness.length() / total * 100;

        powerPorcentages.put("Power", powerPorcentage);
        powerPorcentages.put("Weakness", weaknessPorcentage);

        return powerPorcentages;
    }

    private double getTotalPower() {
        double total = descriptionOfPower.length() + weakness.length();
        return total;
    }

}
