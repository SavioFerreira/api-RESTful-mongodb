package com.saviofc.apimongo.services;

import com.saviofc.apimongo.domain.User;
import com.saviofc.apimongo.dto.UserDTO;
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

    public User insert(User obj){

        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        Optional<User> optionalUser = repository.findById(obj.getId());

            User newObj = optionalUser.get();
            updateData(newObj, obj);
            return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
