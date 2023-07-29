package com.saviofc.apimongo.config;

import com.saviofc.apimongo.domain.User;
import com.saviofc.apimongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User luffy = new User(null, "Luffy","luffy@onepiece.com");
        User chopper = new User(null, "Chopper","chopper@onepiece.com");
        User usopp = new User(null, "Usopp","usopp@onepiece.com");

        userRepository.saveAll(Arrays.asList(luffy, chopper, usopp));
    }
}
