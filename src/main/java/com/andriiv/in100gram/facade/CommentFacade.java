package com.andriiv.in100gram.facade;

import com.andriiv.in100gram.dto.CommentDTO;
import com.andriiv.in100gram.entities.Comment;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Andriiv (03.05.2023 - 10:13)
 */
@Component
public class CommentFacade {

    public CommentDTO commentToCommentDTO(Comment comment) {

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setUsername(comment.getUsername());
        commentDTO.setMessage(comment.getMessage());

        return commentDTO;
    }
}
