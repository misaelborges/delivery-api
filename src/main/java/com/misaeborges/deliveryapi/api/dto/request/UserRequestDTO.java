package com.misaeborges.deliveryapi.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    //The password must contain at least 8 characters, at least 1 letter and 1 number
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Senha deve conter pelo menos 8 caracteres, uma letra maiúscula, uma minúscula, um número e um símbolo")
    @NotBlank
    private String password;
}
