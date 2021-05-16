package Model;

public class MedicalRecord {

	private String medRecordID;
	
	private String symptoms;
	
	private String observation;
	
	private String diagnosis;
	
	private String notes;
	
	private String patientID;
	
	private String doctorID;
	
	

	public String getMedRecordID() {
		return medRecordID;
	}

	public void setMedRecordID(String medRecordID) {
		this.medRecordID = medRecordID;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	
	
}
