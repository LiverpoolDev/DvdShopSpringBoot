package com.sterlit.dvd.dto;

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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    private String name;

    @Mapper
    public abstract static class MapToView {
        public static final CategoryDTO.MapToView mapCategory = Mappers.getMapper(CategoryDTO.MapToView.class);

        @Mappings({

        })
        public abstract CategoryDTO toView(Category entity);

        @Mappings({
        })
        public abstract Category toEntity(CategoryDTO dto);


        @AfterMapping
        void customMapping(@MappingTarget Category entity, CategoryDTO dto) {
            entity.setLastUpdate(new Date());
        }
    }
}
