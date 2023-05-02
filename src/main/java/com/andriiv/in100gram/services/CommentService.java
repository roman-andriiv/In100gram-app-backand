package com.andriiv.in100gram.services;

import com.andriiv.in100gram.dto.CommentDTO;
import com.andriiv.in100gram.entities.Comment;
import com.andriiv.in100gram.entities.Post;
import com.andriiv.in100gram.entities.User;
import com.andriiv.in100gram.exceptions.PostNotFoundException;
import com.andriiv.in100gram.repositories.CommentRepository;
import com.andriiv.in100gram.repositories.PostRepository;
import com.andriiv.in100gram.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

/**
 * Created by Roman Andriiv (02.05.2023 - 14:28)
 */
@Service
public class CommentService {
    public static final Logger LOG = LoggerFactory.getLogger(CommentService.class);
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    public Comment saveComment(Long postId, CommentDTO commentDTO, Principal principal) {

        User user = getUserByPrincipal(principal);
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException("Post cannot be found for username: " + user.getUsername()));

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUserId(user.getId());
        comment.setUserName(user.getUsername());
        comment.setMessage(commentDTO.getMessage());

        LOG.info("Saving comment for Post {}", post.getId());
        return commentRepository.save(comment);
    }

    public List<Comment> getAllCommentsForPost(Long postId) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new PostNotFoundException("Post cannot be found"));

        return commentRepository.findAllByPost(post);
    }

    public void deleteComment(Long commentId) {
        commentRepository.findById(commentId).ifPresent(commentRepository::delete);
    }


    private User getUserByPrincipal(Principal principal) {

        String username = principal.getName();
        return userRepository.findUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username " + username));
    }
}
