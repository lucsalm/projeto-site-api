package com.project.dto.request.user;


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
    @Pattern(regexp = "^\\(?([1-9]{2})\\)([ ])([0-9]{5})([-])([0-9]{4})$", message = "Telefone inválido")
    private String telephone;

    @NotNull
    private String cep;

    @NotNull
    private String address;

    @NotNull
    private Integer addressNumber;
}
