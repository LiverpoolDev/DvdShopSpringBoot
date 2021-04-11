package com.sterlit.dvd.controller;

import com.sterlit.dvd.dto.ActorDTO;
import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.repo.ActorRepository;
import com.sterlit.dvd.service.ActorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.sterlit.dvd.dto.ActorDTO.MapToView.mapActor;


@AllArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {

   private ActorService actorService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> createNewActor(@RequestBody ActorDTO dto){
       return new ResponseEntity(actorService.createActor(dto), HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteActorById(@PathVariable Long id){
         return new ResponseEntity(actorService.deleteActor(id), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id){
        return new ResponseEntity(actorService.findById(id), HttpStatus.OK);

    }
    @GetMapping("/getbyfirstname")
    public ResponseEntity<List<Actor>> findActorByFirstName(@RequestParam(name = "firstName") String firstName){
        return new ResponseEntity(actorService.findActorByFirstName(firstName), HttpStatus.OK);
    }
    @GetMapping("/getbylastname")
    public ResponseEntity<List<Actor>> findActorByLastName(@RequestParam(name = "lastName") String lastName){
        return new ResponseEntity(actorService.findActorByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ActorDTO>> getAll() {
       return new ResponseEntity(actorService.getAll(), HttpStatus.OK);

    }

}
