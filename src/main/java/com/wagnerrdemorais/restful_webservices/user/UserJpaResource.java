package com.wagnerrdemorais.restful_webservices.user;

import com.wagnerrdemorais.restful_webservices.exception.UserNotFoundException;
import com.wagnerrdemorais.restful_webservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {


    private final UserRepository userRepository;

    public UserJpaResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{userId}")
    public EntityModel<User> getUser(@PathVariable Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getUsers());

        EntityModel<User> entityModel = EntityModel.of(user);
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> addUser(@RequestBody @Valid User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
