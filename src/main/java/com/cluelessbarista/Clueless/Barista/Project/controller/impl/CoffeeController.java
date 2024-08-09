package com.cluelessbarista.Clueless.Barista.Project.controller.impl;

import com.cluelessbarista.Clueless.Barista.Project.controller.dto.CoffeeNamesDTO;
import com.cluelessbarista.Clueless.Barista.Project.controller.dto.CoffeePosterDTO;
import com.cluelessbarista.Clueless.Barista.Project.controller.interfaces.ICoffeeController;
import com.cluelessbarista.Clueless.Barista.Project.model.Coffee;
import com.cluelessbarista.Clueless.Barista.Project.repository.CoffeeRepository;
import com.cluelessbarista.Clueless.Barista.Project.service.interfaces.ICoffeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CoffeeController implements ICoffeeController {

//    @Autowired
//    CoffeeRepository coffeeRepository;

    @Autowired
    ICoffeeService coffeeService;


    /*====GET REQUEST====*/
    @GetMapping("/coffees")
    public List<Coffee> getAllCoffees() {
        return coffeeService.getAllCoffee();
    }

    @GetMapping("/coffee/{id}")
    public Coffee getCoffeeById(@PathVariable Integer id) {
        return coffeeService.getCoffeeById(id);
    }

    /*====POST REQUEST====*/ //for creating
    @PostMapping("/coffees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCoffee(@RequestBody @Valid Coffee coffee) {
        coffeeService.saveCoffee(coffee);
    }

    /*====PUT REQUEST====*/ //for updating
    @PutMapping("/coffees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoffee(@RequestBody @Valid Coffee coffee, @PathVariable Integer id) {
        coffeeService.updateCoffee(coffee, id);

    }

    /*====PATCH REQUEST====*/ //same as PUT, but this one you dont need the whole object, you can pick what you wanna update. A request to update one property in a table
    @PatchMapping("coffees/name/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchCoffee(@RequestBody @Valid CoffeeNamesDTO coffeeNamesDTO, @PathVariable Integer id) {
        coffeeService.updateCoffeeName(coffeeNamesDTO.getCoffeeName(), id);
    }

    @PatchMapping("coffees/poster/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchCoffeePoster(@RequestBody @Valid CoffeePosterDTO coffeePosterDTO, @PathVariable Integer id) {
        coffeeService.updateCoffeePoster(coffeePosterDTO.getPostedBy(), id);
    }



    /*====DELETE REQUEST====*/
    @DeleteMapping("/coffee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoffee(@PathVariable Integer id) {
        coffeeService.deleteCoffee(id);
    }

}
