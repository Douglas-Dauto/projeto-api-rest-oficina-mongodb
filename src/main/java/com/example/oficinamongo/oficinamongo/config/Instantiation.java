package com.example.oficinamongo.oficinamongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.oficinamongo.oficinamongo.domain.Post;
import com.example.oficinamongo.oficinamongo.domain.User;
import com.example.oficinamongo.oficinamongo.repositories.PostRepository;
import com.example.oficinamongo.oficinamongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post("Vou viajar para Austrália. Abraços!", sdf.parse("21/03/2024"), null, "Partiu viagem", maria);
        Post post2 = new Post("Acordei feliz hoje!", sdf.parse("12/05/2024"), null, "Bom dia", maria);

        postRepository.saveAll(Arrays.asList(post1, post2));
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
