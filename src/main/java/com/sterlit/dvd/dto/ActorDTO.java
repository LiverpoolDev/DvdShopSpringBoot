package com.sterlit.dvd.dto;


        import com.sterlit.dvd.entity.Actor;
        import com.sterlit.dvd.repo.FilmRepository;
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;
        import org.mapstruct.*;
        import org.mapstruct.factory.Mappers;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.Date;
        import java.util.List;
        import java.util.stream.Collectors;

        import static com.sterlit.dvd.dto.FilmDTO.MapToView.mapFilm;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActorDTO {
    private String firstName;
    private String lastName;
    private List<FilmDTO> films;


    @Mapper
    @Component
    public abstract static class MapToView {
        public static final ActorDTO.MapToView mapActor = Mappers.getMapper(ActorDTO.MapToView.class);


        @Mappings({
        })
        public abstract ActorDTO toView(Actor entity);

        @Mappings({
        })
        public abstract Actor toEntity(ActorDTO dto);


        @AfterMapping
        void customMapping(@MappingTarget ActorDTO dto, Actor entity) {
            entity.setLastUpdate(new Date());
        }
    }
}
