package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.loanapplication;
import com.example.demo.Model.login;
import com.example.demo.Model.user;
import com.example.demo.Service.loanapplicationService;
import com.example.demo.Service.userService;

@RestController
@CrossOrigin
public class userController {
	@Autowired
	userService us;
	@Autowired
	loanapplicationService ser;
	@GetMapping("/fetch")
	public List<user> getUserDetails()
	{
		List<user> userList=us.getUserDetails();
		return userList;
	}
	
	@PostMapping("/userlogin")
	public String validateUser(@RequestBody login logindata)
	{
		return us.ValidateUser(logindata.getEmail(),logindata.getPassword());
	}
	@PostMapping("/usersignup")
	public user newUser(@RequestBody user user)
	{
		return us.newUser(user);
	}
	@GetMapping("/getloan/{loanid}")
	public loanapplication getLoan(@PathVariable int loanid)
	{
		return us.getLoan(loanid);
	}
	@PutMapping("/putuserdetails")
	public user putprofile(@RequestBody user ob) {
		return us.putprofile(ob);
	}
	@DeleteMapping("/deletedetails/{id}")
	public String deleteprofile(@PathVariable("id") int id)
	{
		return us.deleteprofile(id);
	}

}