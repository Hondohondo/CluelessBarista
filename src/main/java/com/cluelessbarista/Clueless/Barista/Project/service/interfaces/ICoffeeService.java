package com.cluelessbarista.Clueless.Barista.Project.service.interfaces;


import com.cluelessbarista.Clueless.Barista.Project.model.Coffee;

import java.util.List;

public interface ICoffeeService {
    List<Coffee> getAllCoffee();
    Coffee getCoffeeById(Integer id);

    void saveCoffee(Coffee coffee);

    void updateCoffee(Coffee coffee, Integer id);

    void updateCoffeeName(String coffeeName, Integer id);

    void updateCoffeePoster(String postedBy, Integer id);

    void deleteCoffee(Integer id);
}
