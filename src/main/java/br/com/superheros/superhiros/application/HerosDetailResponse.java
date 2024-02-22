package br.com.superheros.superhiros.application;

import br.com.superheros.superhiros.model.HerosModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class HerosDetailResponse {
    private UUID idHeros;
    private String name;
    private String powerOfTheHeros;
    private String descriptionOfPower;
    private String weakness;
    private LocalDateTime hourOfRegister;

    public HerosDetailResponse(HerosModel herosModel) {
        this.idHeros = herosModel.getIdHeros();
        this.name = herosModel.getName();
        this.powerOfTheHeros = herosModel.getPowerOfTheHeros();
        this.descriptionOfPower = herosModel.getDescriptionOfPower();
        this.weakness = herosModel.getWeakness();
        this.hourOfRegister = LocalDateTime.now();
    }
}
