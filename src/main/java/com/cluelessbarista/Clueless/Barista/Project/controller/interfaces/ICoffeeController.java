package com.cluelessbarista.Clueless.Barista.Project.controller.interfaces;

import com.cluelessbarista.Clueless.Barista.Project.model.Coffee;

import java.util.List;

//interface here is just to help us to prevent errors but could also have been left out
public interface ICoffeeController {
    public List<Coffee> getAllCoffees();
    public Coffee getCoffeeById(Integer id);
}
