package br.com.superheros.superhiros.heros.application;

import br.com.superheros.superhiros.heros.model.HerosModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class HerosListResponse {
    private UUID idHeros;
    private String name;
    private String powerOfTheHeros;
    private LocalDateTime hourOfRegister;

    public HerosListResponse(HerosModel herosModel) {
        this.idHeros = herosModel.getIdHeros();
        this.name = herosModel.getName();
        this.powerOfTheHeros = herosModel.getPowerOfTheHeros();
        this.hourOfRegister = LocalDateTime.now();
    }

    public static List<HerosListResponse> Converte(List<HerosModel> herosModels) {
        return herosModels.stream()
                .map(HerosListResponse::new)
                .collect(Collectors.toList());
    }
}
