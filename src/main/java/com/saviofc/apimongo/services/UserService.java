package com.saviofc.apimongo.services;

import com.saviofc.apimongo.domain.User;
import com.saviofc.apimongo.repositories.UserRepository;
import com.saviofc.apimongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){

        return repository.findAll();
    }

    public User findById(String id){

        Optional<User> userOptional = repository.findById(id);

        return userOptional.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado para o ID: " + id));

    }
}
