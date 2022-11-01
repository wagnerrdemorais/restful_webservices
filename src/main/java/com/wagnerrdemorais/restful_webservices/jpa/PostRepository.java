package com.wagnerrdemorais.restful_webservices.jpa;

import com.wagnerrdemorais.restful_webservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
