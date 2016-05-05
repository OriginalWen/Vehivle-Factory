/**
 * CSYE6200 Vehicle starter class
 * Assignment 2B
 * Jinjin Zhang
 * NUID: 001749261
 * 
 */
package edu.neu.csye6200.vehicle;

import java.io.Serializable;

public class Vehicle implements Serializable{
	int passengers;
	int fuelCap;
	String make;
	String model;
	int modelYear;
	String type;
	double mpg;
	String licensePlate;
	
	Vehicle (){
		passengers=5;
		fuelCap=100;
		make="Volvo";
		model="S80";
		modelYear=2013;
		type="truck";
		mpg=30;
		licensePlate="VBG 984";
	}
	Vehicle (String lp){
		passengers=5;
		fuelCap=100;
		make="Volvo";
		model="S80";
		modelYear=2013;
		type="truck";
		mpg=30;
		this.licensePlate=lp;
	}
	
	Vehicle(String type,String make,String model,int modelYear){
		this.type=type;
		this.make=make;
		this.model=model;
		this.modelYear=modelYear;
		if(type=="minivan"){
			this.passengers=8;
			this.fuelCap=15;
			this.mpg=28;
			this.licensePlate="VBG 984";
		}
		if(type=="sportscar"){
			this.passengers=2;
			this.fuelCap=15;
			this.mpg=20;
			this.licensePlate="VBG 999";
		}
	}
	
	double calcRange() {
	    double range = fuelCap * mpg;
	    return range;
	}
	
	public void printDet(){
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("Type of the vehicle: "+this.type);
		System.out.println("Number of maximum passengers: "+this.passengers);
		System.out.println("Capacity of the fuel is: "+this.fuelCap);
		System.out.println("Make: "+this.make);
		System.out.println("Model: "+this.model);
		System.out.println("Model year: "+this.modelYear);
		System.out.println("Mile per gallon (MPG): "+this.mpg);
		System.out.println("Range of this vehicle: "+this.calcRange());
		System.out.println("License Plate of this vehicle is: "+this.licensePlate);
	}
}
