package com.saviofc.apimongo.services;

import com.saviofc.apimongo.domain.Usuario;
import com.saviofc.apimongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<Usuario> findAll(){

        return repository.findAll();
    }
}
