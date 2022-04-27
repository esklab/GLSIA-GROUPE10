package com.glsiA.projet.service;

import com.glsiA.projet.models.User;
import com.glsiA.projet.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InitService implements CommandLineRunner {

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public InitService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) {

        //creation de l'admin
        User admin = new User("admin", passwordEncoder.encode("admin"),"Adjaro","edina","ADMIN","");

        List<User> users = Arrays.asList(admin);

        //enregistrer l'admin en BD
        if(this.userRepository.count() <= 0) {
            this.userRepository.saveAll(users);
        }

    }
}
