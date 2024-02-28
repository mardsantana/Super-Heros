package br.com.superheros.superhiros.heros.application;

import br.com.superheros.superhiros.heros.model.HerosModel;
import br.com.superheros.superhiros.powers.dto.PowerDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Data
public class HerosDetailResponse {
    private UUID idHeros;
    private String name;
    private String powerOfTheHeros;
    private LocalDateTime hourOfRegister;
    private List<PowerDTO> powers;


    public HerosDetailResponse(HerosModel herosModel) {
        this.idHeros = herosModel.getIdHeros();
        this.name = herosModel.getName();
        this.powerOfTheHeros = herosModel.getPowerOfTheHeros();
        this.hourOfRegister = LocalDateTime.now();
        this.powers = herosModel.getPower()
                .stream().map(PowerDTO::new)
                .collect(Collectors.toList());

    }
}
