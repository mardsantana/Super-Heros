package br.com.superheros.superhiros.model;


import br.com.superheros.superhiros.dto.HerosDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Table(name = "Heros")
public class HerosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idHeros;
    private String name;
    private String powerOfTheHeros;
    private String descriptionOfPower;
    private String weakness;
    private LocalDateTime hourOfRegister;

    public HerosModel(HerosDTO herosDTO) {
        this.name = herosDTO.getName();
        this.powerOfTheHeros = herosDTO.getPowerOfTheHeros();
        this.descriptionOfPower = herosDTO.getDescriptionOfPower();
        this.weakness = herosDTO.getWeakness();
    }
}
