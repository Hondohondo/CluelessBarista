package com.cluelessbarista.Clueless.Barista.Project.repository;

import com.cluelessbarista.Clueless.Barista.Project.model.Coffee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoffeeRepositoryTest {

    @Autowired
    private CoffeeRepository coffeeRepository;

    Coffee coffee;

    @BeforeEach
    void setUp() {
        coffee = new Coffee("Affogato", "vanilla ice cream, espresso", "1. Place a scoop of vanilla ice cream in a serving cup. 2. Pour a shot of hot espresso over the ice cream. 3. Serve immediately", "Ami Amigo");

        coffeeRepository.save(coffee);
    }

    @AfterEach
    void tearDown() {
        coffeeRepository.deleteById(coffee.getCoffeeId());
    }

    @Test
    public void findAll_coffees_coffeeList() {
        List<Coffee> coffeeList = (List<Coffee>) coffeeRepository.findAll();
        System.out.println(coffeeList);
        assertEquals(7, coffeeList.size());
    }

    @Test
    public void findById() {
        Optional<Coffee> coffee = coffeeRepository.findById(3);
        assertTrue(coffee.isPresent());
        System.out.println(coffee.get());
        assertEquals("Mocha",coffee.get().getCoffeeName());
    }

    @Test
    public void findById_invalidId() {
        Optional<Coffee> coffee = coffeeRepository.findById(10);
//        assertFalse(coffee.isPresent());
        assertTrue(coffee.isEmpty());
    }

    @Test
    public void findByCoffeeName_validCoffeeName_correctCoffee() {
        Optional<Coffee> coffee = coffeeRepository.findByCoffeeName("Affogato");
        assertTrue(coffee.isPresent());
        assertEquals("Affogato", coffee.get().getCoffeeName());
        System.out.println(coffee);
    }

    @Test
    public void findAllByPostedBy_validPostedBy_coffeeList() {
        List<Coffee> coffeeList = coffeeRepository.findAllByPostedBy("Ami Amigo");
        System.out.println(coffeeList);
        assertEquals(2, coffeeList.size());
    }

    @Test
    public void findAllByCoffeeIngredientsContaining_validCoffeeIngredients_coffeeList() {
        List<Coffee> coffeeList = coffeeRepository.findAllByCoffeeIngredientsContaining("milk");
        System.out.println(coffeeList);
        assertEquals(3, coffeeList.size());
    }





}