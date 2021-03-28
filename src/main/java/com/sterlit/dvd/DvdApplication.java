package com.sterlit.dvd;


import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.repo.ActorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;


@SpringBootApplication
public class DvdApplication implements ApplicationRunner {

    @Autowired
    ActorRepository repository;

    public static void main(String[] args)  {
        SpringApplication.run(DvdApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Actor> actor = repository.findById(4L);
        System.out.println(actor.orElseThrow(() -> new NotFoundException("Актер не найден ")));

    }
}
