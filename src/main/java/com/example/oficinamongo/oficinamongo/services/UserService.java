package com.example.oficinamongo.oficinamongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oficinamongo.oficinamongo.domain.User;
import com.example.oficinamongo.oficinamongo.dto.UserDTO;
import com.example.oficinamongo.oficinamongo.repositories.UserRepository;
import com.example.oficinamongo.oficinamongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado."));
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());

        updateData(newObj, obj);

        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
