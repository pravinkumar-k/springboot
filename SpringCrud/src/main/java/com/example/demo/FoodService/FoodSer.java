package com.example.demo.FoodService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.FoodModel.FoodDetails;
import com.example.demo.FoodRepository.FoodRepo;

import jakarta.transaction.Transactional;

@Service
public class FoodSer {
	@Autowired
	FoodRepo repo;
	
	public String saveFood(FoodDetails fooddtl)
	{
		repo.save(fooddtl);
		return "Thanks";
	}
	public List<FoodDetails>getCustomer()
	{
		return repo.findAll();
	}
	public Optional<FoodDetails>getCustomerById(int id)
	{
		return repo.findById(id);
	}
	public String getSave(FoodDetails fooddtl)
	{
		repo.save(fooddtl);
		return "UPDATED!!!";
	}
	public void deleteByRequestParam(int id)
	{
		repo.deleteById(id);
	}
	
	
	
	

	public List<FoodDetails> sortData(String field) {
		//return studRepository.findAll(Sort.by(field));
		return repo.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	
	public List<FoodDetails> descsortData(String field) {
		//return studRepository.findAll(Sort.by(field));
		return repo.findAll(Sort.by(Sort.Direction.DESC, field));
	}
	
	public List<FoodDetails> pagination(int offset,int pagesize)
	{
		Page<FoodDetails> page=repo.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	//delete queries
		@Transactional
		public int deletefoodByname(String name)
		{
			return repo.deletefoodByname(name);
		}
		
		//update queries
		@Transactional
		public int updatefood(int calories,String name)
		{
			return repo.updatefood(calories,name);
		}
		
		//native queries
		@Transactional
		public List<FoodDetails> fetchfoodBydays(String totaldays)
		{
			return repo.fetchfoodBydays(totaldays);
		}
		
		//select queries1
		public List<FoodDetails> getfoodByName(String name,String id)
		{
			return repo.getfoodByName(name,id);
		}
		
		//select query2
		public List<FoodDetails> getfoodByname(String name)
		{
			return repo.getfoodByname(name);
		}
		
		//fetch by name start
		public List<FoodDetails> fetchfoodBynamePrefix(String prefix)
		{
			return repo.findBynameStartingWith(prefix);
		}
		//fetch by name end
		public List<FoodDetails> fetchfoodBynameSuffix(String suffix)
		{
			  return repo.findBynameEndingWith(suffix);
		}
		//fetch by total days
		public List<FoodDetails> fetchfoodBytotaldays(String totaldays)
		{
			return repo.findBytotaldays(totaldays);
		}
		

}
