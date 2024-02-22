package br.com.superheros.superhiros.application;

import br.com.superheros.superhiros.model.HerosModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class HerosListDTO {
    private UUID idHeros;
    private String name;
    private String powerOfTheHeros;
    private String descriptionOfPower;
    private String weakness;
    private LocalDateTime hourOfRegister;

    public HerosListDTO(HerosModel herosModel) {
        this.idHeros = herosModel.getIdHeros();
        this.name = herosModel.getName();
        this.powerOfTheHeros = herosModel.getPowerOfTheHeros();
        this.descriptionOfPower = herosModel.getDescriptionOfPower();
        this.weakness = herosModel.getWeakness();
        this.hourOfRegister = LocalDateTime.now();
    }

    public static List<HerosListDTO> Converte(List<HerosModel> herosModels) {
        return herosModels.stream()
                .map(HerosListDTO::new)
                .collect(Collectors.toList());
    }
}
