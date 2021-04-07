package com.sterlit.dvd.controller;

import com.sterlit.dvd.dto.ActorDTO;
import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.repo.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.sterlit.dvd.dto.ActorDTO.MapToView.mapActor;


@AllArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {

   private ActorRepository actorRepository;

    @PostMapping("/create")
    public Actor createNewActor(@RequestBody ActorDTO dto){
       return actorRepository.save(mapActor.toEntity(dto));

    }
    @DeleteMapping("/delete/{id}")
    public String deleteActorById(@PathVariable Long id){
         actorRepository.deleteById(id);
         return  "Delete " + id;
    }

    @GetMapping("/get/{id}")
    public Actor findById(@PathVariable Long id){
        return actorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Актер с указаным ID %d не найден", id)));
    }
    @GetMapping("/getbyfirstname")
    public List<Actor> getActorByName(@RequestParam(name = "firstName") String firstName){
        return actorRepository.findActorByFirstName(firstName);
    }
    @GetMapping("/getbylastname")
    public List<Actor> getActorByLastName(@RequestParam(name = "lastName") String lastName){
        return actorRepository.findActorByLastName(lastName);
    }

    @GetMapping
    public List<ActorDTO> getAll() {
       return actorRepository.findAll()
                .stream()
                .map(mapActor::toView).collect(Collectors.toList());
    }

}
