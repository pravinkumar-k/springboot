package com.example.demo.FoodRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.FoodModel.FoodDetails;

@Repository
public interface FoodRepo extends JpaRepository<FoodDetails, Integer>{
	//delete queries
	@Modifying
	@Query("delete from FoodDetails s where s.name=?1")
	public int deletefoodByname(String name);
	
	//update queries
	@Modifying
	@Query("update FoodDetails s set s.calories=?1 where s.name=?2 ")
	public int updatefood(int calories,String name);
	
	//native queries
	@Query(value="select*from food_details s where s.totaldays=?1",nativeQuery=true)
	public List<FoodDetails>fetchfoodBydays(String totaldays);
	
	//select queries1
	@Query("select s from FoodDetails s where s.name=:name and s.id=:id")
	public List<FoodDetails> getfoodByName(String name,String id);

    //select query2
	@Query("select s from FoodDetails s where s.name=:name")
	public List<FoodDetails> getfoodByname(String name);
	
	//fetch
	List<FoodDetails> findBynameStartingWith(String prefix);
	List<FoodDetails> findBynameEndingWith(String suffix);
	List<FoodDetails> findBytotaldays(String totaldays);

}
