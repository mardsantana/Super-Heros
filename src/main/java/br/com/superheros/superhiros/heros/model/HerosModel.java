package br.com.superheros.superhiros.heros.model;


import br.com.superheros.superhiros.heros.dto.HerosDTO;
import br.com.superheros.superhiros.powers.dto.PowerDTO;
import br.com.superheros.superhiros.powers.model.PowerModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    @OneToMany(mappedBy = "idHeros", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PowerModel> power;

    public HerosModel(HerosDTO herosDTO) {
        this.name = herosDTO.getName();
        this.powerOfTheHeros = herosDTO.getPowerOfTheHeros();
    }

    public void update(HerosDTO herosDTO) {
        this.name = herosDTO.getName();
        this.powerOfTheHeros = herosDTO.getPowerOfTheHeros();
    }
}
