package by.pochepko.controller;

import by.pochepko.dto.ChocolateDto;
import by.pochepko.service.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateRestController {

    @Autowired
    private ChocolateService chocolateService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<ChocolateDto> getChocolates() {
        return chocolateService.getChocolateLst();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public ChocolateDto getChocolateById(@PathVariable final long id) {
        return chocolateService.getChocolateById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")

    public ChocolateDto createChocolate(@RequestBody ChocolateDto newChocolateDto) {

        return chocolateService.createChocolate(newChocolateDto);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")

    public void updateChocolate(@RequestBody ChocolateDto newChocolateDto) {
        chocolateService.updateChocolate(newChocolateDto);

    }


}
