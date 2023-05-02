package com.andriiv.in100gram.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Created by Roman Andriiv (02.05.2023 - 12:42)
 */

@Data
public class UserDTO {

    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String username;
    private String bio;

}
