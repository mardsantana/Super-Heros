package br.com.superheros.superhiros.heros.application;

import br.com.superheros.superhiros.heros.model.HerosModel;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class HerosResponse {
    private UUID idHeros;

    public HerosResponse(HerosModel herosModel) {
        this.idHeros = herosModel.getIdHeros();
    }
}
