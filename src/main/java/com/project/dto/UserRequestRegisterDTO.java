package com.project.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestRegisterDTO extends UserRequestDTO {

    @NotNull
    @Valid
    private String username;

    @NotNull
    @Pattern(regexp = "^(\\+\\d{1,9}\\s)?\\(?\\d{2}\\)?[\\s.-]?\\d{5}[\\s.-]?\\d{4}$", message = "Telefone inválido")
    private String telephone;
}
