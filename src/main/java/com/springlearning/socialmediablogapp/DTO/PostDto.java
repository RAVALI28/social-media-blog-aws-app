package com.springlearning.socialmediablogapp.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Data


public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String description;
}
