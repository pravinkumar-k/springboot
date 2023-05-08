package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.loanapplication;

public interface loanapplicationRepo extends JpaRepository<loanapplication,Integer>{

}