package by.pochepko.controller;

import by.pochepko.dto.ChocolateDto;
import by.pochepko.model.Chocolate;
import by.pochepko.service.ChocolateDtoMapper;
import by.pochepko.service.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateRestController {
    @Autowired
    private ChocolateDtoMapper chocolateDtoMapper;

    @Autowired
    private ChocolateService chocolateService;


    @GetMapping
    public List<ChocolateDto> getChocolates() {

        List<ChocolateDto> chocolateList = chocolateService.getChocolateLst().stream()
                .map(chocolateDtoMapper::modelToDTO)
                .collect(Collectors.toList());

        return chocolateList;
    }

    @GetMapping(value = "/{id}")
    public ChocolateDto getChocolateById(@PathVariable("id") final long id) {

        ChocolateDto chocolateDto = chocolateDtoMapper
                .modelToDTO(chocolateService
                        .getChocolateById(id));
        return chocolateDto;
    }

    @PostMapping
    public ChocolateDto createChocolate(@RequestBody ChocolateDto newChocolateDto) {
        Chocolate newChocolate = chocolateDtoMapper.DtoToModel(newChocolateDto);
        ChocolateDto createdChocolateDto = chocolateDtoMapper
                .modelToDTO(chocolateService
                        .createChocolate(newChocolate));

        return createdChocolateDto;
    }

    @PutMapping
    public void updateChocolate(@RequestBody ChocolateDto newChocolateDto) {
        Chocolate newChocolate = chocolateDtoMapper.DtoToModel(newChocolateDto);
        chocolateService.updateChocolate(newChocolate);

    }


}
