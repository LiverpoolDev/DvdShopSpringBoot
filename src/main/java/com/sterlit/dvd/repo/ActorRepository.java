package com.sterlit.dvd.repo;

import com.sterlit.dvd.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findActorByFirstName(String firstName);

    List<Actor> findActorByLastName(String lastName);
    Actor findActorByFirstNameAndLastName(String firstName, String lastName);

}
