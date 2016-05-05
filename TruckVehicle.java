package edu.neu.csye6200.vehicle;
public class TruckVehicle extends Vehicle{
	double height,width,length;
	public TruckVehicle() {
		//units of measure here are meter
		height=2.8;
		width=3.2;
		length=6.5;
	}
	public double cargoArea(){
		return this.height*this.width*this.length;
	}
	public void printTruckDet(){
		super.printDet();
		System.out.println("The cargo area of this truck is "+this.cargoArea()+" stere");
	}
}
