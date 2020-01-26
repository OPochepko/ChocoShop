package by.pochepko.controller;

import by.pochepko.model.Chocolate;
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
    public List<Chocolate> getChocolates() {
        return chocolateService.getChocolateLst();
    }

    @GetMapping(value = "/{id}")
    public Chocolate getChocolateById(@PathVariable("id") final long id) {
        return chocolateService.getChocolateById(id);
    }

    @PostMapping
    public Chocolate createChocolate(@RequestBody Chocolate newChocolate) {

        return chocolateService.createChocolate(newChocolate);
    }

    @PutMapping
    public void updateChocolate(@RequestBody Chocolate newChocolate) {
        chocolateService.updateChocolate(new Chocolate());
    }


}
