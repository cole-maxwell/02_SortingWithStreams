package cs681;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class Car 
{
	private String make;
	private String model;
	private int mileage;
	private int year;
	private int price;
	private int dominationCount = -1;
	
	private Car(String make, String model, int mileage, int year, int price)	{
		
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	
	public static Car createCar(String make, String model, int mileage, int year, int price)	{
		return new Car(make, model, mileage, year, price);
	}
	
	public String getMake()	{
		return this.make;
	}
	
	public String getModel()	{
		return this.model;
	}
	
	public int getMileage()	{
		return this.mileage;
	}
	
	public int getYear()	{
		return this.year;
	}
	
	public int getPrice()	{
		return this.price;
	}

	public int getDominationCount() {
		return dominationCount;
	}
	public void setDominationCount(ArrayList<Car> cars) {
		this.dominationCount = 0;
		for (Car otherCar: cars) {
			if (!this.equals(otherCar)) {
				if ((otherCar.getMileage() <= this.mileage
					&& otherCar.getPrice() <= this.price)
					&& (otherCar.getMileage() < this.mileage
					|| otherCar.getPrice() < this.price)) {
						dominationCount++;
					}
			}
		}
	}

	public String toString() {
		if (this.dominationCount == -1) {
			return String.format("%s%n%s%n%s%n%s%n%s",
			"Make: " + this.make,
			"Model: " + this.model,
			"Year: " + this.year,
			"Mileage: " + this.mileage,
			"Domination count: " + this.dominationCount + " (domination count has not been set)");
		} else {
			return String.format("%s%n%s%n%s%n%s%n%s",
			"Make: " + this.make,
			"Model: " + this.model,
			"Year: " + this.year,
			"Mileage: " + this.mileage,
			"Domination count: " + this.dominationCount);
		}
	}
}

