package Services;

//IT19128696 Mandakini G.H

import java.util.ArrayList;


import Model.Doctor;

public interface IDoctorService {

	public ArrayList<String> getDoctorID();
	
	public void addDoctor(Doctor doctor);
	
	public Doctor getDoctor(String doctorID);
	
	public Doctor updateDoctor(String doctorID, Doctor doctor);
	
	public void deleteDoctor(String doctorID);
	
	public ArrayList<Doctor> listDoctors(); 
}
