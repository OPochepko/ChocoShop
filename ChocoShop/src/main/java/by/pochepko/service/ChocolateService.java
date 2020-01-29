package by.pochepko.service;

import by.pochepko.dto.ChocolateDto;

import java.util.List;

public interface ChocolateService {

    List<ChocolateDto> getChocolateLst();

    void updateChocolate(ChocolateDto chocolate);

    ChocolateDto createChocolate(ChocolateDto chocolate);

    ChocolateDto getChocolateById(Long id);

}
