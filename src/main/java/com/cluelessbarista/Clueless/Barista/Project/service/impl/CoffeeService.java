package com.cluelessbarista.Clueless.Barista.Project.service.impl;

import com.cluelessbarista.Clueless.Barista.Project.model.Coffee;
import com.cluelessbarista.Clueless.Barista.Project.repository.CoffeeRepository;
import com.cluelessbarista.Clueless.Barista.Project.service.interfaces.ICoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService implements ICoffeeService {

    @Autowired
    CoffeeRepository coffeeRepository;

    @Override
    public List<Coffee> getAllCoffee() {
//        return List.of();
        return (List<Coffee>) coffeeRepository.findAll();
    }

    @Override
    public Coffee getCoffeeById(Integer id) {
        Optional<Coffee> coffeeOptional =  coffeeRepository.findById(id);
        return coffeeOptional.orElse(null);
    }

    @Override
    public void saveCoffee(Coffee coffee) {
        coffeeRepository.save(coffee);
    }

    @Override
    public void updateCoffee(Coffee coffee, Integer id) {
        //we need to check first if the course exists
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);
        if (coffeeOptional.isEmpty()) {
            return;
        } else {
            coffeeRepository.save(coffee);
        }
    }

    @Override
    public void updateCoffeeName(String coffeeName, Integer id) {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);
        if (coffeeOptional.isEmpty()) {
            return;
        } else {
            Coffee coffee = coffeeOptional.get();
            coffee.setCoffeeName(coffeeName);
            coffeeRepository.save(coffee);
        }
    }

    @Override
    public void updateCoffeePoster(String postedBy, Integer id) {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);
        if (coffeeOptional.isEmpty()) {
            return;
        } else {
            Coffee coffee = coffeeOptional.get();
            coffee.setPostedBy(postedBy);
            coffeeRepository.save(coffee);
        }
    }

    @Override
    public void deleteCoffee(Integer id) {
        Optional<Coffee> coffeeOptional = coffeeRepository.findById(id);
        if (coffeeOptional.isEmpty()) {
            return;
        } else {
            coffeeRepository.deleteById(id);
        }
    }
}
