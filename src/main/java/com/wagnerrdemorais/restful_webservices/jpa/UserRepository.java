package com.wagnerrdemorais.restful_webservices.jpa;

import com.wagnerrdemorais.restful_webservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
