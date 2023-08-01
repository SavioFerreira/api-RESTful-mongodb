package com.saviofc.apimongo.repositories;

import com.saviofc.apimongo.domain.Post;
import com.saviofc.apimongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
