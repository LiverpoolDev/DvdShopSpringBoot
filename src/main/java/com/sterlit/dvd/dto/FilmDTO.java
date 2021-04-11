package com.sterlit.dvd.dto;

import com.sterlit.dvd.entity.Actor;
import com.sterlit.dvd.entity.Category;
import com.sterlit.dvd.entity.Film;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.sterlit.dvd.dto.CategoryDTO.MapToView.mapCategory;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmDTO {

    private String title;
    private Integer releaseYear;
    private Integer length;
    private String rating;
    private List<CategoryDTO> categories;

    @Mapper
    public abstract static class MapToView {
        public static final FilmDTO.MapToView mapFilm = Mappers.getMapper(FilmDTO.MapToView.class);

        @Mappings({

        })
        public abstract FilmDTO toView(Film entity);

        @Mappings({
        })
        public abstract Film toEntity(FilmDTO dto);


        @AfterMapping
        void customMapping(@MappingTarget FilmDTO dto, Film entity) {
            List<CategoryDTO> categoryDTO = entity.getCategories()
                    .stream()
                    .map(mapCategory::toView)
                    .collect(Collectors.toList());
            dto.setCategories(categoryDTO);
            entity.setLastUpdate(new Date());
        }
    }
}
