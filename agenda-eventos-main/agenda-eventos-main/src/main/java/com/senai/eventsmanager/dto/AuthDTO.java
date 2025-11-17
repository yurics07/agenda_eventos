package com.senai.eventsmanager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

    @NotBlank(message = "O Email deve ser preenchido")
    private String Email;

    @NotBlank(message = "A senha deve ser preenchido")
    private String senha;

}
