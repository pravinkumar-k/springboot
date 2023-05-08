package com.example.demo.FoodService;
import com.example.demo.FoodModel.foodlogmodel;
import com.example.demo.FoodRepository.foodlogrepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class foodlogservice {

@Autowired
private foodlogrepository lrepo;
public String checkLogin(String username,String password)
{
	foodlogmodel user= lrepo.findByUsername(username);
	if(user==null)
	{
		return "No user found";
	}
	else
	{
		if(user.getPassword().equals(password))
		{
			return "Login Succesfull";
		}
		else
		{
			return "Login Failed";
		}
	}
} 
public foodlogmodel addUser(foodlogmodel cl)
{
	return lrepo.save(cl);
}
public List<foodlogmodel> getUser()
{
	return lrepo.findAll();
}
public foodlogmodel putUser(foodlogmodel cl)
{
	return lrepo.save(cl);
}
}