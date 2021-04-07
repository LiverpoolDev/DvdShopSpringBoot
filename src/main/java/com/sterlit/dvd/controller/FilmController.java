package com.sterlit.dvd.controller;


import com.sterlit.dvd.dto.ActorDTO;
import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.entity.Film;
import com.sterlit.dvd.repo.ActorRepository;
import com.sterlit.dvd.repo.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/film")
@AllArgsConstructor
public class FilmController {

  private FilmRepository filmRepository;
  private ActorRepository actorRepository;

    @DeleteMapping("/delete/{id}")
    public String deleteFilmById(@PathVariable Long id){
        filmRepository.deleteById(id);
        return  "Delete " + id;
    }

    @GetMapping("/get/{id}")
    public Film findById(@PathVariable Long id){
        return filmRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Киннофильм с указаным ID %d не найден", id)));
    }
    @GetMapping("/getbytitle")
    public Film getFilmByTitle(@RequestParam(name = "title") String title){
        return filmRepository.findByTitle(title);
    }
    @GetMapping("/releaseyear")
    public Film getFilmByReleaseYear(@RequestParam(name = "releaseyear") Integer releaseYear){
        return filmRepository.findByReleaseYear(releaseYear);
    }
    @GetMapping("/rating")
    public Film getFilmByRating(@RequestParam(name = "rating") String rating){
        return filmRepository.findByRating(rating);
    }
    @PostMapping(value = "/getbyactor")
    public List<Film> findFilmByActor(@RequestBody ActorDTO dto){
        Actor actor = actorRepository.findActorByFirstNameAndLastName(dto.getFirstName(),dto.getLastName());
        return filmRepository.findByActors(actor);
    }
}
