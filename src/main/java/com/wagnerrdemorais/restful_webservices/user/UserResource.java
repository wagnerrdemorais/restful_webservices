package com.wagnerrdemorais.restful_webservices.user;

import com.wagnerrdemorais.restful_webservices.exception.UserNotFoundException;
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
public class UserResource {

    private final UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{userId}")
    public EntityModel<User> getUser(@PathVariable Integer userId) {
        User user = userDaoService.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getUsers());

        EntityModel<User> entityModel = EntityModel.of(user);
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody @Valid User user) {
        User savedUser = userDaoService.addUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        if (userDaoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            throw new UserNotFoundException("user not found");
        }
    }
}
