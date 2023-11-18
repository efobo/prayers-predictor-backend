package com.group.genshinProg.model.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {
    @NotEmpty
    private String name;
}
