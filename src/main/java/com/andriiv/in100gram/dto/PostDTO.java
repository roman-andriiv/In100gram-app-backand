package com.andriiv.in100gram.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

/**
 * Created by Roman Andriiv (02.05.2023 - 13:18)
 */
@Data
public class PostDTO {
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    private String location;
    private String username;
    private Integer likes;
    private Set<String> usersLiked;
}
