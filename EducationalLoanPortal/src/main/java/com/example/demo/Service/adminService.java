package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.loanapplication;
import com.example.demo.Repository.loanapplicationRepo;

@Service
public class adminService {
	 @Autowired
	 loanapplicationRepo loanApp;
	 public List<loanapplication> getAdmin()
	 {
		 return loanApp.findAll();
	 }
     public loanapplication saveDetails(loanapplication lm)
     {
    	 return loanApp.save(lm);
     }
     public loanapplication putDetails(loanapplication ab)
     {
    	 return loanApp.saveAndFlush(ab);
     }
    public void deleteDetails(int loanid)
    {
    	loanApp.deleteById(loanid);
    }

}