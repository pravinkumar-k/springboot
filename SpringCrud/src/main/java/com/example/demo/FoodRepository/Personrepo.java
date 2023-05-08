package com.example.demo.FoodRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.FoodModel.Person;

@Repository
public interface Personrepo extends JpaRepository<Person,Long>{

}
