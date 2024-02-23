package br.com.superheros.superhiros.heros.dto;

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
    @Column(table = "hour_of_register")
    private LocalDateTime hourOfRegister;
}
