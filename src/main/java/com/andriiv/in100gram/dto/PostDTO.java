package com.andriiv.in100gram.dto;

import lombok.Data;

import java.util.Set;

/**
 * Created by Roman Andriiv (02.05.2023 - 13:18)
 */
@Data
public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String username;
    private Integer likes;
    private Set<String> usersLiked;
}
