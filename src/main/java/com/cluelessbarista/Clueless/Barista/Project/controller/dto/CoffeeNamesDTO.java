package com.cluelessbarista.Clueless.Barista.Project.controller.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class CoffeeNamesDTO {
    @Column(name = "coffee_name")
    @NotEmpty(message = "Coffee can't be empty. Come up with a name")
    private String coffeeName;

    public String getCoffeeName() {
        return coffeeName;
    }
}
