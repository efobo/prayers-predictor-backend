package com.group.genshinProg.model.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class ThreeStarDTO implements Serializable {

    private int amount;
}
