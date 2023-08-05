package com.saviofc.apimongo.config;

import com.saviofc.apimongo.domain.Post;
import com.saviofc.apimongo.domain.User;
import com.saviofc.apimongo.dto.AuthorDTO;
import com.saviofc.apimongo.dto.CommentDTO;
import com.saviofc.apimongo.repositories.PostRepository;
import com.saviofc.apimongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

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

        User luffy = new User(null, "Luffy","luffy@onepiece.com");
        User chopper = new User(null, "Chopper","chopper@onepiece.com");
        User usopp = new User(null, "Usopp","usopp@onepiece.com");
        User zoro = new User(null, "Zoro","zoro@onepiece.com");


        userRepository.saveAll(Arrays.asList(luffy, chopper, usopp, zoro));

        Post postUm = new Post(null, sdf.parse("31/07/2023"), "Cap Usopp", "Meu nome é Capitão Usopp!!", new AuthorDTO(usopp));
        Post postDois = new Post(null, sdf.parse("30/07/2023"), "Doc Chopper", "Eu vou criar a cura para todas as doenças do mundo!", new AuthorDTO(chopper));

        CommentDTO c1 = new CommentDTO("kkkk capitão? aonde, nariz de tritão!!", sdf.parse("31/07/2023"), new AuthorDTO(luffy));
        CommentDTO c2 = new CommentDTO("Chopaaaa", sdf.parse("31/07/2023"), new AuthorDTO(luffy));
        CommentDTO c3 = new CommentDTO("Calma luffy, ele tem família lkkkjjj", sdf.parse("31/07/2023"), new AuthorDTO(zoro));

        postUm.getComments().addAll(Arrays.asList(c1, c3));
        postDois.getComments().add(c2);

        postRepository.saveAll(Arrays.asList(postUm, postDois));

        chopper.getPosts().add(postUm);
    }
}
