package com.example.oficinamongo.oficinamongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oficinamongo.oficinamongo.domain.Post;
import com.example.oficinamongo.oficinamongo.repositories.PostRepository;
import com.example.oficinamongo.oficinamongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> user = postRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado."));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
