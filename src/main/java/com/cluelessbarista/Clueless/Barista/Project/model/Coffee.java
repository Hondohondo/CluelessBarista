package com.cluelessbarista.Clueless.Barista.Project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coffee_id")
    private Integer coffeeId;

    @Column(name = "coffee_name")
    @NotEmpty(message = "Coffee can't be empty. Come up with a name")
    private String coffeeName;

    @Column(name = "coffee_ingredients")
    private String coffeeIngredients;

    @Column(name = "coffee_instructions")
    private String coffeeInstructions;

    @Column(name = "posted_by")
    private String postedBy;

    public Coffee() {
    }

    public Coffee(String coffeeName, String coffeeIngredients, String coffeeInstructions, String postedBy) {
        this.coffeeName = coffeeName;
        this.coffeeIngredients = coffeeIngredients;
        this.coffeeInstructions = coffeeInstructions;
        this.postedBy = postedBy;
    }

    public Integer getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Integer coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getCoffeeIngredients() {
        return coffeeIngredients;
    }

    public void setCoffeeIngredients(String coffeeIngredients) {
        this.coffeeIngredients = coffeeIngredients;
    }

    public String getCoffeeInstructions() {
        return coffeeInstructions;
    }

    public void setCoffeeInstructions(String coffeeInstructions) {
        this.coffeeInstructions = coffeeInstructions;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeId=" + coffeeId +
                ", coffeeName='" + coffeeName + '\'' +
                ", coffeeIngredients='" + coffeeIngredients + '\'' +
                ", coffeeInstructions='" + coffeeInstructions + '\'' +
                ", postedBy='" + postedBy + '\'' +
                '}';
    }
}
