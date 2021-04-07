package com.sterlit.dvd.dto;


import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.entity.Film;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActorDTO {
    private String firstName;
    private String lastName;
    private List<Film> films;


    @Mapper
    public abstract static class MapToView {
        public static final ActorDTO.MapToView mapActor = Mappers.getMapper(ActorDTO.MapToView.class);

        @Mappings({
//                @Mapping(target = "type", source = "photo.type"),
        })
        public abstract ActorDTO toView(Actor entity);

        @Mappings({
        })
        public abstract Actor toEntity(ActorDTO dto);


        @AfterMapping
        void customMapping(@MappingTarget Actor entity, ActorDTO dto) {
            entity.setLastUpdate(new Date());
        }
    }
}
