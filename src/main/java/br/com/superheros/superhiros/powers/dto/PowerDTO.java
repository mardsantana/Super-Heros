package br.com.superheros.superhiros.powers.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PowerDTO {
    @NotBlank
    @Column(table = "description_of_power", columnDefinition = "TEXT")
    private String descriptionOfPower;
    @NotBlank
    private String weakness;
    @Column(table = "hour_of_register")
    private LocalDateTime hourOfRegister;
}
