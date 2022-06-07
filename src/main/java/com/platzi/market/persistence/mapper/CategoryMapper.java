package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    //Mapeando las tablas de persistencia con el Dominio
    @Mappings(
            {
                    @Mapping(source = "idCategoria", target = "categoryId"),
                    @Mapping(source = "descripcion", target = "category"),
                    @Mapping(source = "estado", target = "active"),
            }
    )
Category toCategory(Categoria categoria);

    //Mapeando a la inversa
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
