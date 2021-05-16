package Model;

public class Doctor extends Employee {

	public  String DoctorID;
	
	//default constructor
	public Doctor() {}
	

	/**
	 * @return the DoctorID
	 */
	
	public String getDoctorID() {
		return DoctorID;
	}
	
	/**
	 * @param DoctorID the DoctorID to set
	 */
	public void setDoctorID(String doctorID) {
		DoctorID = doctorID;
	}
	
	@Override
	public String toString() {
		return super.toString() +"Doctor ID " + DoctorID;
	}
	
	
}
