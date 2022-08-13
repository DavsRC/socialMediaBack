package com.sofka.davs.socialMediaBack.userlike.infrastructure.rest_controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLikeDTO {

    private Integer id;
    private String name;
    private String dni;

}
