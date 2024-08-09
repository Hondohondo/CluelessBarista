package com.cluelessbarista.Clueless.Barista.Project.repository;

import com.cluelessbarista.Clueless.Barista.Project.model.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends CrudRepository<Coffee, Integer> {
//public interface CoffeeRepository extends JPARepository<Coffee, Integer> {

    //Using JPA
    Optional<Coffee> findByCoffeeName(String coffeeName);
    List<Coffee> findAllByPostedBy(String postedBy);
    List<Coffee> findAllByCoffeeIngredientsContaining(String coffeeIngredients);


}
