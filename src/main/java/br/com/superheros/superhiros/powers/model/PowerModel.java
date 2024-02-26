package br.com.superheros.superhiros.powers.model;

import br.com.superheros.superhiros.heros.model.HerosModel;
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
}
