package com.example.demo.FoodRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.FoodModel.Address;

@Repository
public interface Addressrepo extends JpaRepository<Address,Long> {

}
