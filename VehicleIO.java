package edu.neu.csye6200.vehicle;

public interface VehicleIO {
	//save all vehicles in this registration to direction filename
	void save();
	//save this vehicle to direction filename
	void save(Vehicle v);
	//load all vehicles in this registration from direction filename
	void load(String filename, VehicleRegistry reg);
}
