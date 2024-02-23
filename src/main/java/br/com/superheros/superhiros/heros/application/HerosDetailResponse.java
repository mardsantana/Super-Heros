package br.com.superheros.superhiros.heros.application;

import br.com.superheros.superhiros.heros.model.HerosModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class HerosDetailResponse {
    private UUID idHeros;
    private String name;
    private String powerOfTheHeros;
    private LocalDateTime hourOfRegister;

    public HerosDetailResponse(HerosModel herosModel) {
        this.idHeros = herosModel.getIdHeros();
        this.name = herosModel.getName();
        this.powerOfTheHeros = herosModel.getPowerOfTheHeros();
        this.hourOfRegister = LocalDateTime.now();
    }
}
