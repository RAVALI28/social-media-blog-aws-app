package com.springlearning.socialmediablogapp.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Content")
    private String Content;


}
