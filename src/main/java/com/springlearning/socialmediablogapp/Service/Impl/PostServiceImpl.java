package com.springlearning.socialmediablogapp.Service.Impl;

import com.springlearning.socialmediablogapp.DTO.PostDto;
import com.springlearning.socialmediablogapp.Entity.Post;
import com.springlearning.socialmediablogapp.Exception.ResourceNotFoundException;
import com.springlearning.socialmediablogapp.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        //Map Post Dto to Post Entity
        Post post = mapDtoToEntity(postDto);

        //Save to DB
        Post savedPost = postRepository.save(post);

        //Map Post Entity to Post Dto
        PostDto savedPostDto = mapEntityToDto(savedPost);
        return savedPostDto;
    }




    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        //Map Post Entity to PostDTO
       List<PostDto> postDtoList = allPosts.stream().map(post -> mapEntityToDto(post)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public PostDto getPostById(long id) {
       Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(id)));
        PostDto postDtoById = mapEntityToDto(post);
        return postDtoById;
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
       Post existedPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(id)));
        existedPost.setTitle(postDto.getTitle());
        existedPost.setContent(postDto.getContent());
        existedPost.setDescription(postDto.getDescription());
        Post updatedPost = postRepository.save(existedPost);
        return mapEntityToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post existingPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", String.valueOf(id)));
        postRepository.delete(existingPost);

    };


    private PostDto mapEntityToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }


    private Post mapDtoToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return post;
    }


}
