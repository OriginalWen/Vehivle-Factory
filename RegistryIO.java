package edu.neu.csye6200.vehicle;
import java.io.*;
import java.util.logging.*;
public class RegistryIO implements VehicleIO{
	private static Logger log = Logger.getLogger(RegistryIO.class.getName());
	public RegistryIO() {
		log.info("Constructing a RegistryIO instance");
	} 
	public void save(String filename, VehicleRegistry reg) {
		for(Vehicle v:reg.arraylistGetter()){
			 save(filename, v);
		}
	}
	public void streamOut(Vehicle v,String filename){
		try{
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(v);
			oos.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Vehicle load(String filename){
		Vehicle v=null;
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			v=(Vehicle)ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return v;
	}
	public void load(String filename, VehicleRegistry reg) {
		 try {
			 FileReader fr = new FileReader(filename);
			 BufferedReader in = new BufferedReader(fr);
			 String line=null;
			 while ((line= in.readLine()) != null) {
				 System.out.println(line);
			 }
			 in.close();
			 log.info("Files loaded successfully.");
		 } catch (IOException e) {
			 log.warning("This is a severe message"); 
			 e.printStackTrace();
		 }
	}
	private void save(String filename, Vehicle v){
		FileWriter fw;
		 try {
			 fw = new FileWriter(filename,false);
			 fw.write("\r\n");
			 fw.write("Type of the vehicle is "+v.type+"\r\n");
			 fw.write("licensePlate of the vehicle is "+v.licensePlate+"\r\n");
			 fw.write("Number of maximum passengers: "+v.passengers+"\r\n");
			 fw.write("Capacity of the fuel is: "+v.fuelCap);
			 fw.write("Make: "+v.make+"\r\n");
			 fw.write("Model: "+v.model+"\r\n");
			 fw.write("Model year: "+v.modelYear+"\r\n");
			 fw.write("Mile per gallon (MPG): "+v.mpg+"\r\n");
			 fw.write("Range of this vehicle: "+v.calcRange()+"\r\n");
			 fw.close();
			 log.info("Files saved successfully.");
		 } catch(IOException ex) {
			 log.warning("This is a severe message"); 
			 System.err.println("IO ERROR received: " + ex.getMessage());
			 ex.printStackTrace();
		 }
	}
	public void saveSingleVehicle(String filename, Vehicle v){
		save(filename, v);
	}
	public void save(){
		
	};
	public void save(Vehicle v){
		
	};
}
