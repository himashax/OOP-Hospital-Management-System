package Services;

//IT19128696 Mandakini G.H

import java.util.ArrayList;


import Model.Appointments;

public interface IAppointmentService {

	public ArrayList<String> getAppointmentID();
	
	public void addAppointment(Appointments appointment);
	
	public Appointments getAppointments(String appID);
	
	public Appointments updateAppointment(String appID, Appointments appointment);
	
	public void deleteAppointment(String appID);
	
	public ArrayList<Appointments> listAppointments();
	
	public ArrayList<Appointments> listAppointmentsPatient(String patientID);
	
	public ArrayList<Appointments> listAppointmentsDoctor(String doctorID);
}
