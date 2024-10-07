package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    //TODO : DB 와 상호작용하는 annotation
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//primary key(기본키)

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String bio;

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
//
//    @OneToMany(mappedBy = "user")
//    private List<Like> likes;
//
//    @OneToMany(mappedBy = "follower")
//    private List<Follow> followings;
//
//    @OneToMany(mappedBy = "following")
//    private List<Follow> followers; 이 부분은 추후 기능 구현시 필요해 주석 처리했습니다.

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.bio = null;
        this.joinedAt = LocalDateTime.now();
        this.imageUrl = null;
    }
}