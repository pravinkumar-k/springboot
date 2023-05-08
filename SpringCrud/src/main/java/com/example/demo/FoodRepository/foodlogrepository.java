package com.example.demo.FoodRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.FoodModel.foodlogmodel;
@Repository
public interface foodlogrepository extends JpaRepository<foodlogmodel,Integer>{
	foodlogmodel findByUsername(String name);

}
