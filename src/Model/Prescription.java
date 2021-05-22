package Model;


//Prescription model class

public class Prescription {

	private String prescriptionID;
	
	private String name;
	
	private String dose;
	
	private String patientID;
	
	private String doctorID;

	/**
	 * @return the prescriptionID
	 */
	public String getPrescriptionID() {
		return prescriptionID;
	}

	/**
	 * @param prescriptionID the prescriptionID to set
	 */
	public void setPrescriptionID(String prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dose
	 */
	public String getDose() {
		return dose;
	}

	/**
	 * @param dose the dose to set
	 */
	public void setDose(String dose) {
		this.dose = dose;
	}

	/**
	 * @return the patientID
	 */
	public String getPatientID() {
		return patientID;
	}

	/**
	 * @param patientID the patientID to set
	 */
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	/**
	 * @return the doctorID
	 */
	public String getDoctorID() {
		return doctorID;
	}

	/**
	 * @param doctorID the doctorID to set
	 */
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	
	
	
}
