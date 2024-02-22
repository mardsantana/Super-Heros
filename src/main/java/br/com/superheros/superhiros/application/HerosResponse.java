package br.com.superheros.superhiros.application;

import br.com.superheros.superhiros.model.HerosModel;
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
