package com.example.demo.FoodController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FoodModel.FoodDetails;
import com.example.demo.FoodService.FoodSer;



@RestController

public class Food {
	@Autowired
	FoodSer food;
	
	@PostMapping("/")
	public String addDetails(@RequestBody FoodDetails fooddtl)
	{
		return food.saveFood(fooddtl);
	}
	@GetMapping("/")
	public List<FoodDetails>read()
	{
		return food.getCustomer();
	}
	@GetMapping("/{id}")
	public Optional<FoodDetails>readByID(@PathVariable int id)
	{
		return food.getCustomerById(id);
	}
	@PutMapping("/{id}")
	public String update(@RequestBody FoodDetails fooddtl)
	{
		return food.getSave(fooddtl);
	}
	@DeleteMapping("/delete")
	public String delete(@RequestParam("fid") int id)
	{
		food.deleteByRequestParam(id);
		return "deleted";
	}
	
	
	
	//sorting
	@GetMapping("/sort/{field}")
	public List<FoodDetails> sortvote(@PathVariable String field)
	{
		return food.sortData(field);
	}
	@GetMapping("/descsort/{field}")
	public List<FoodDetails> descsortvote(@PathVariable String field)
	{
		return food.descsortData(field);
	}
	
	@GetMapping("/pagination/{offset}/{pagesize}")
	public List<FoodDetails> page(@PathVariable int offset,@PathVariable int pagesize)
	{
		return food.pagination(offset, pagesize);
	}
	
	
	
	//delete queries

	
	@DeleteMapping("/deletemapping1/{name}")
	public String deletefoodByname(@PathVariable("name") String name)
	{
		 int result=food.deletefoodByname(name);
		 if(result>0)
			 return "Food record is deleted";
		 else
			 return"No record found";
	}
	
	//update queries
	@PutMapping("/updatebyquery/{cal}/{name}")
	public String updatefood(@PathVariable int calories,@PathVariable String name)
	{
		int res=food.updatefood(calories,name);
		if(res>0)
			return "food record updated";
		else
			return "Problem occured while updating";
	}
	
	//native queries
	@GetMapping("fetchbydays/{totaldays}")
	public List<FoodDetails> fetchfoodBydays(@PathVariable String totaldays){
		return food.fetchfoodBydays(totaldays);
	}
	
	//select query1
	@GetMapping("getfoodByName/{name}/{id}")
	public List<FoodDetails> getfoodByName(@PathVariable String name,@PathVariable String id)
	{
		return food.getfoodByName(name,id);
	}

	//select query2
	@GetMapping("getfoodByname/{name}")
	public List<FoodDetails> getfoodByname(@PathVariable String name)
	{
		return food.getfoodByname(name);
	}
	
	//fetch by name start

	@GetMapping("/prefixname")
	public List<FoodDetails> fetchFoodDetailsBynamePrefix(@RequestParam String prefix)
	{
		 return food.fetchfoodBynamePrefix(prefix);
	}
	//fetch by name end

	@GetMapping("/Suffixname")
	public List<FoodDetails>fetchfoodBynameSuffix(@RequestParam String suffix)
	{
		return food.fetchfoodBynameSuffix(suffix);
	}
	//fetch by theme

	@GetMapping("/gettheme")
	public List<FoodDetails> fetchfoodBytotaldays(@RequestParam String totaldays)
	{
		return food.fetchfoodBytotaldays(totaldays);
	}
	
}
