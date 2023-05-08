package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.loanapplication;
import com.example.demo.Model.user;
import com.example.demo.Repository.loanapplicationRepo;
import com.example.demo.Repository.userRepo;

@Service
public class userService {
	@Autowired
	userRepo repobj;
	@Autowired
	loanapplicationRepo lobj;
	public String ValidateUser(String email,String password)
	{
		user u=repobj.findByEmail(email);
		if(u==null)
		{
			return "No User Found";
		}
		else
		{
			if(u.getPassword().equals(password))
			{
				return "Login Successfull";
			}
			else
			{
				return "Login Falied";
			}
		}
	}
	public user newUser(user user)
	{
		return repobj.save(user);
	}
	
	public List<user> getUserDetails()
	{
		return repobj.findAll();
	}
	
	public loanapplication getLoan(int loanid)
	{
		loanapplication l=lobj.findById(loanid).get();
		return l;
	}
	public user getProfile(int id)
	{
		user u=repobj.findById(id).get();
		return u;
	}
	public user putprofile(user ob) {
	
		return repobj.saveAndFlush(ob);
	}
	public String deleteprofile(int id) {
		repobj.deleteById(id);
		return "deleted";
	}
				

}