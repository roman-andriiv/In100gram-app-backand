package com.andriiv.in100gram.facade;

import com.andriiv.in100gram.dto.PostDTO;
import com.andriiv.in100gram.entities.Post;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Andriiv (03.05.2023 - 10:07)
 */
@Component
public class PostFacade {

    public PostDTO postToPostDTO(Post post) {

        PostDTO postDTO = new PostDTO();
        postDTO.setUsername(post.getUser().getUsername());
        postDTO.setId(post.getId());
        postDTO.setDescription(post.getDescription());
        postDTO.setLikes(post.getLikes());
        postDTO.setUsersLiked(post.getLikedUsers());
        postDTO.setLocation(post.getLocation());
        postDTO.setTitle(post.getTitle());

        return postDTO;
    }
}
