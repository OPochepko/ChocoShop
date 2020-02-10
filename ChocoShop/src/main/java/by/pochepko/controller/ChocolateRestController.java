package by.pochepko.controller;

import by.pochepko.dto.ChocolateDto;
import by.pochepko.service.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateRestController {

    @Autowired
    private ChocolateService chocolateService;

    @GetMapping
    public List<ChocolateDto> getChocolates() {
        return chocolateService.getChocolateLst();
    }

    @GetMapping(value = "/{id}")
    public ChocolateDto getChocolateById(@PathVariable final long id) {
        return chocolateService.getChocolateById(id);
    }

    @PostMapping
    public ChocolateDto createChocolate(@RequestBody ChocolateDto newChocolateDto) {

        return chocolateService.createChocolate(newChocolateDto);
    }

    @PutMapping
    public void updateChocolate(@RequestBody ChocolateDto newChocolateDto) {
        chocolateService.updateChocolate(newChocolateDto);

    }


}
