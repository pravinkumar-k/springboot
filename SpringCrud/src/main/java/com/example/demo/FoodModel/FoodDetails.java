package com.example.demo.FoodModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FoodDetails {
	@Id
	private int id;
	private String name;
	private long totaldays;
	private int calories;
	private int cholesterol;
	private int dietry_fiber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getTotaldays() {
		return totaldays;
	}
	public void setTotaldays(long totaldays) {
		this.totaldays = totaldays;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}
	public int getDietry_fiber() {
		return dietry_fiber;
	}
	public void setDietry_fiber(int dietry_fiber) {
		this.dietry_fiber = dietry_fiber;
	}
	@Override
	public String toString() {
		return "FoodDetails [id=" + id + ", name=" + name + ", totaldays=" + totaldays + ", calories=" + calories
				+ ", cholesterol=" + cholesterol + ", dietry_fiber=" + dietry_fiber + "]";
	}
	
}
