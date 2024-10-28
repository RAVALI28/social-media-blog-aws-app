package com.springlearning.socialmediablogapp.Controller;


import com.springlearning.socialmediablogapp.DTO.PostDto;
import com.springlearning.socialmediablogapp.Service.Impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")  //Base URL
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto savedPostDto = postService.createPost(postDto);
        return new ResponseEntity(savedPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/getAllPosts")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    };

    //api/posts/{id}
    @GetMapping("/getPostById/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }


    @PutMapping("/updatePostById/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable long id){
       PostDto updatedPostResponse = postService.updatePost(postDto,id);
      return  ResponseEntity.ok(updatedPostResponse);
    };

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable long id){
        postService.deletePostById(id);
       return ResponseEntity.ok("Deleted Successfully Post Resource ::" +id);
    };


}
