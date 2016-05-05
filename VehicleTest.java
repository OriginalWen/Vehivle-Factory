/**
 * CSYE6200 Vehicle starter class
 * Assignment 2B
 * Jinjin Zhang
 * NUID: 001749261
 * 
 */
package edu.neu.csye6200.vehicle;

public class VehicleTest {
	public static void run(){
		Vehicle minivan = new Vehicle("minivan","DongFeng","X1",2009);
	    Vehicle sportscar = new Vehicle("sportscar","lamborghini","LP 580-2",2016);
	    //minivan.printDet();
	    //sportscar.printDet();
	    VehicleRegistry reg=VehicleRegistry.instance();
	    reg.addVehicle(minivan);
	    reg.addVehicle(sportscar);
	    reg.printVehicles();
	    reg.mapRetriever("VBG 984");
	    TruckVehicle truck=new TruckVehicle();
		truck.printTruckDet();
		RegistryIO regIO=new RegistryIO();
		regIO.save("D:\\test.txt",reg);
		regIO.load("D:\\test.txt",reg);
		reg.addVehicle(new Vehicle("AHD-354"));
		reg.addVehicle(new Vehicle("BSF-786"));
		reg.addVehicle(new Vehicle("CDF-825"));
		reg.addVehicle(new Vehicle("DDG-625"));
		reg.addVehicle(new Vehicle("EJG-896"));
		reg.addVehicle(new Vehicle("FED-123"));
		reg.addVehicle(new Vehicle("GSS-776"));
		reg.addVehicle(new Vehicle("SDS-964"));
		reg.loadVehicle(3);
		reg.deleteVehicle(minivan);
		reg.sortsVehicles();
	}

	public static void main(String args[]){
		VehicleTest.run();
	}	
}
