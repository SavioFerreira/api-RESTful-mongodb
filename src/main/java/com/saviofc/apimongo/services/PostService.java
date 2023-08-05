package com.saviofc.apimongo.services;

import com.saviofc.apimongo.domain.Post;
import com.saviofc.apimongo.domain.User;
import com.saviofc.apimongo.repositories.PostRepository;
import com.saviofc.apimongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private PostRepository  repository;

    public Post findById(String id){

        Optional<Post> postOptional = repository.findById(id);

        return postOptional.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado para o ID: " + id));

    }

}
