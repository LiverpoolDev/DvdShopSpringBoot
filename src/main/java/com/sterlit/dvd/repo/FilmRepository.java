package com.sterlit.dvd.repo;

import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByTitle(String title);

    Film findByRentalRate(Integer rentalRate);

    Film findByReleaseYear(Integer releaseYear);

    Film findByRating(String rating);

    List<Film> findByActors(Actor actor);
}
