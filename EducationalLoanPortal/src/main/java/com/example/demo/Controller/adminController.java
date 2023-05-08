package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.loanapplication;
import com.example.demo.Service.adminService;

@RestController
public class adminController {
	@Autowired
	adminService as;
	
	@GetMapping("/getAdminDetails")
	public List<loanapplication> getAdmin()
	{
		List<loanapplication> adminList =as.getAdmin();
		return adminList;
	}
	@PostMapping("/adduser")
	public loanapplication saveDetails(@RequestBody loanapplication lm)
	{
		return as.saveDetails(lm);
	}
	@PutMapping("/putuser")
	public loanapplication putDetails(@RequestBody loanapplication ab)
	{
		return as.putDetails(ab);
	}
	
	@DeleteMapping("/deleteuser1/{loanid}")
	public String deleteDetails(@PathVariable("loanid") int loanid)
	{
		 as.deleteDetails(loanid);
		 return "deleted";
	}

}