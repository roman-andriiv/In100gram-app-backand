package com.andriiv.in100gram.web;

import com.andriiv.in100gram.dto.PostDTO;
import com.andriiv.in100gram.entities.Post;
import com.andriiv.in100gram.facade.PostFacade;
import com.andriiv.in100gram.payload.response.MessageResponse;
import com.andriiv.in100gram.services.PostService;
import com.andriiv.in100gram.validations.ResponseErrorValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Roman Andriiv (03.05.2023 - 13:40)
 */

@RestController
@RequestMapping("api/post")
@CrossOrigin
public class PostController {

    private final PostService postService;
    private final PostFacade postFacade;
    private final ResponseErrorValidation responseErrorValidation;

    @Autowired
    public PostController(PostService postService, PostFacade postFacade, ResponseErrorValidation responseErrorValidation) {
        this.postService = postService;
        this.postFacade = postFacade;
        this.responseErrorValidation = responseErrorValidation;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPost(@Valid @RequestBody PostDTO postDTO,
                                             BindingResult bindingResult,
                                             Principal principal) {

        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) {
            return errors;
        }
        Post post = postService.createPost(postDTO, principal);
        PostDTO createdPost = postFacade.postToPostDTO(post);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDTO>> getAllPosts() {

        List<PostDTO> allPosts = postService.getAllPosts()
                .stream()
                .map(postFacade::postToPostDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("user/posts")
    public ResponseEntity<List<PostDTO>> getAllPostsForUser(Principal principal) {

        List<PostDTO> allPostsForUser = postService.getAllPostsForUser(principal)
                .stream()
                .map(postFacade::postToPostDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allPostsForUser, HttpStatus.OK);
    }

    @PostMapping("/{postId}/{username}/like")
    public ResponseEntity<PostDTO> likePost(@PathVariable("postId") String postId,
                                            @PathVariable("username") String username) {

        Post post = postService.likePost(Long.parseLong(postId), username);
        PostDTO postDTO = postFacade.postToPostDTO(post);

        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    @PostMapping("/{postId}/delete")
    public ResponseEntity<MessageResponse> deletePost(@PathVariable("postId")String postId, Principal principal){
        postService.deletePost(Long.parseLong(postId), principal);
        return new ResponseEntity<>(new MessageResponse("Post was deleted"), HttpStatus.OK);
    }
}
