package br.com.superheros.superhiros.heros.model;


import br.com.superheros.superhiros.heros.dto.HerosDTO;
import jakarta.persistence.*;
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
    private LocalDateTime hourOfRegister;

    public HerosModel(HerosDTO herosDTO) {
        this.name = herosDTO.getName();
        this.powerOfTheHeros = herosDTO.getPowerOfTheHeros();
    }

    public void update(HerosDTO herosDTO) {
        this.name = herosDTO.getName();
        this.powerOfTheHeros = herosDTO.getPowerOfTheHeros();
    }
}
