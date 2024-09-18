package com.example.oficinamongo.oficinamongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.oficinamongo.oficinamongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
