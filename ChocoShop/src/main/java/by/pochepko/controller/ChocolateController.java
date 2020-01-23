package by.pochepko.controller;

import by.pochepko.dao.ChocolateRepository;
import by.pochepko.model.Chocolate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {
    final
    ChocolateRepository chocolateRepository;
    private List<Chocolate> chocolateList = new ArrayList<>();

    public ChocolateController(ChocolateRepository chocolateRepository) {
        this.chocolateRepository = chocolateRepository;
    }

    @GetMapping
    public List<Chocolate> findAll() {
        return StreamSupport.stream(chocolateRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public Chocolate findById(@PathVariable("id") final long id) {
        return chocolateRepository.findById(id).get();
    }

    @PutMapping
    public Chocolate addChocolate(@RequestBody Chocolate newChocolate) {

        return chocolateRepository.save(newChocolate);
    }


}
