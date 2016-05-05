/**
 * CSYE6200 Vehicle starter class
 * Assignment 2B
 * Jinjin Zhang
 * NUID: 001749261
 * 
 */
package edu.neu.csye6200.vehicle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.*;
import java.io.File;

public class VehicleRegistry {
	private static VehicleRegistry instance = null;	
	private static Logger log = Logger.getLogger(VehicleRegistry.class.getName());
	private VehicleRegistry() {
		log.info("Constructing a VehicleRegistry instance");
	} 
	public static VehicleRegistry instance() {
		 // Creation only happens the first time
		 if (instance == null) instance = new VehicleRegistry();
		 return instance; // All other times we get the first one
	}
	
	private static ArrayList<Vehicle> list=new ArrayList<Vehicle>();
	public ArrayList<Vehicle> arraylistGetter(){
		return list;
	}
	
	private static HashMap<String, Vehicle> map=new HashMap<String, Vehicle>();
	public int NumOfVecRegisted(){
		return list.size();
	}
	
	private String base="D://RegistedVehicles//";
	private File basedir = new File(base);
	private int NumOfVecRegisted=1;
	private RegistryIO regIO=new RegistryIO();
	public void addVehicle(Vehicle v){
		list.add(v);
		map.put(v.licensePlate, v);
		if(!basedir.exists()) basedir.mkdirs();
		regIO.saveSingleVehicle(base+"Vehicle"+Integer.toString(NumOfVecRegisted++)+".txt", v);
	}
	public void loadVehicle(int i){
		regIO.load(base+"Vehicle"+Integer.toString(i)+".txt", this);
		log.info("vehicle loaded successfully.");
	}
	public void deleteVehicle(Vehicle v){
		if(map.containsKey(v.licensePlate)){
			map.remove(v.licensePlate);
		}
		if(list.contains(v)){
			list.remove(v);
			System.out.println("Vehicle successfully deleted");
		}
		else System.out.println("Vehicle requesting delete does not exist");
	}
	public void getNthVehicle(int n){
		if(list.size()<=n) {
			System.out.println("Detail of the Nth vehicle is as following:");
			list.get(n-1).printDet();
		}
		else System.out.println("Nth Vehicle does not exist");
	}
	public void printVehicles(){
		for(int i=0;i<list.size();i++){
			System.out.println("Following is the detail of "+(i+1)+"th vehicle:");
			list.get(i).printDet();
		}
	}
	public void sortsVehicles(){
		for(int i=0;i<list.size()-1;i++){
			for(int j=0;j<list.size()-(1+i);j++){
				if(list.get(j).licensePlate.compareTo(list.get(j+1).licensePlate)>0) {
					list.add(j+2,list.get(j));
					list.remove(j);
				}
			}
		}
		System.out.println("The arraylist has been sorted by license plate.");
		System.out.println("The sorted license plate are as following:");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).licensePlate);
		}
	}
	public void mapRetriever (String licPlate){
		System.out.println("The detail of vehicle having license plate number as "+licPlate+" is as following");
		map.get(licPlate).printDet();
	}
}
