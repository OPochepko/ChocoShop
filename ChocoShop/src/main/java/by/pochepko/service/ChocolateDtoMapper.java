package by.pochepko.service;

import by.pochepko.dto.ChocolateDto;
import by.pochepko.model.Chocolate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChocolateDtoMapper {
    ChocolateDto modelToDTO(Chocolate chocolate);

    Chocolate DtoToModel(ChocolateDto chocolateDto);

}
