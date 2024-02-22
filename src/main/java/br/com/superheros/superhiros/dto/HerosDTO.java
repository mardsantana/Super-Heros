package br.com.superheros.superhiros.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HerosDTO {
    @NotBlank
    @Column(unique = true)
    private String name;
    @NotBlank
    @Column(table = "power_of_the_heros")
    private String powerOfTheHeros;
    @NotBlank
    @Column(table = "description_of_power", columnDefinition = "TEXT")
    private String descriptionOfPower;
    @Column(table = "hour_of_register")
    private LocalDateTime hourOfRegister;
}
