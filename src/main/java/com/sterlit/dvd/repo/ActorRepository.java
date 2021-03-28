package com.sterlit.dvd.repo;

import com.sterlit.dvd.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository <Actor, Long> {


}
