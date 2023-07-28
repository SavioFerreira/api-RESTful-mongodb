package com.saviofc.apimongo.repositories;

import com.saviofc.apimongo.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Usuario, String> {

}
