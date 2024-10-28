package com.springlearning.socialmediablogapp.Repository;

import com.springlearning.socialmediablogapp.DTO.PostDto;
import com.springlearning.socialmediablogapp.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
