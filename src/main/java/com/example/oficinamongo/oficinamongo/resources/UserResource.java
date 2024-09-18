package com.example.oficinamongo.oficinamongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.oficinamongo.oficinamongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User douglas = new User("1", "Douglas", "douglas@gmail.com");
        User junior = new User("2", "Junior", "junior@gmail.com");
        List<User> list = new ArrayList<>();

        list.addAll(Arrays.asList(douglas, junior));

        return ResponseEntity.ok().body(list);
    }
}
