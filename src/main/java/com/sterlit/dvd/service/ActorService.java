package com.sterlit.dvd.service;

import com.sterlit.dvd.dto.ActorDTO;
import com.sterlit.dvd.dto.FilmDTO;
import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.repo.ActorRepository;
import com.sterlit.dvd.repo.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.sterlit.dvd.dto.ActorDTO.MapToView.mapActor;
import static com.sterlit.dvd.dto.FilmDTO.MapToView.mapFilm;

@Service
@Slf4j
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private FilmRepository filmRepository;

    public Boolean createActor(ActorDTO actorDTO) {
        Actor actor = mapActor.toEntity(actorDTO);
        if (actorRepository.save(actor) != null) {
            log.info(String.format("Создан актер с ID "), actor.getId());
            return true;
        }
        return false;
    }

    public ActorDTO findById(Long id) {
        return actorRepository.findById(id).map(this::fillActorDto)
                .orElseThrow(() -> new RuntimeException("Нет такого актера с ID %d"));
    }

    public List<ActorDTO> findActorByFirstName(String firstname) {
        return Optional.of(actorRepository.findActorByFirstName(firstname)
                .stream()
                .map(mapActor::toView)
                .collect(Collectors.toList())).orElseGet((Supplier<? extends List<ActorDTO>>) Collections.EMPTY_LIST);
    }
    public List<ActorDTO> findActorByLastName(String lastname) {
        return Optional.of(actorRepository.findActorByLastName(lastname)
                .stream()
                .map(mapActor::toView)
                .collect(Collectors.toList())).orElseGet((Supplier<? extends List<ActorDTO>>) Collections.EMPTY_LIST);
    }

    public Boolean deleteActor(Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        if (actor.isPresent()) {
            actorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<ActorDTO> getAll() {
        return actorRepository.findAll().stream()
                .map(this::fillActorDto)
                .collect(Collectors.toList());
    }

    private ActorDTO fillActorDto(Actor entity) {
        List<FilmDTO> filmsByActor = filmRepository.findByActors(entity)
                .stream()
                .map(mapFilm::toView)
                .collect(Collectors.toList());
        ActorDTO actorDto = mapActor.toView(entity);
        actorDto.setFilms(filmsByActor);
        return actorDto;
    }
}
