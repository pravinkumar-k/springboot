package com.example.demo.FoodController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.FoodService.foodlogservice;
import com.example.demo.FoodModel.foodlogmodel;
@RestController
@RequestMapping("/user")
public class foodlogcontroller {
	
	@Autowired
	private foodlogservice lser;
	
	@PostMapping("/log")
	public String login(@RequestBody Map<String,String>loginData)
	{
		String username=loginData.get("username");
		String password=loginData.get("password");
		String result=lser.checkLogin(username,password);
		return result;
	}
	@PutMapping("/put")
	public foodlogmodel putUser(@RequestBody foodlogmodel cl)
	{
		return lser.putUser(cl);
	}
	@PostMapping("/adduser")
	public foodlogmodel AddUser(@RequestBody foodlogmodel cl)
	{
		return lser.addUser(cl);
	}
	
	@GetMapping("/showall")
	public List<foodlogmodel> listAll()
	{
		return lser.getUser();
	}
}