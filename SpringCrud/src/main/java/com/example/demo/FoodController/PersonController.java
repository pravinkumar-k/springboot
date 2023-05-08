package com.example.demo.FoodController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FoodModel.Person;
import com.example.demo.FoodService.PersonService;

@RestController
public class PersonController {
  @Autowired
  PersonService serobj;
 @PostMapping("/postfood")
  public Person add(@RequestBody Person name)
  {
	  return serobj.addPerson(name);
  }
  @GetMapping("/getfood")
  public List<Person> get()
  {
	  return serobj.getPerson();
  }
}
