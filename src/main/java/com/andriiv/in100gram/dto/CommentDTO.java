package com.andriiv.in100gram.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Created by Roman Andriiv (02.05.2023 - 14:34)
 */
@Data
public class CommentDTO {
    private Long id;
    @NotEmpty
    private String message;
    private String username;
}
