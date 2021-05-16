package Services;

import java.util.ArrayList;


import Model.MedicalRecord;

public interface IMedicalRecordService {
	
	public void addMedcalRecord(MedicalRecord medicalRecord);
	
	public MedicalRecord getMedicalRecords(String patientID);
	
	public MedicalRecord updateMedicalRecord(String medRecordID, MedicalRecord medicalRecord);
	
	public ArrayList<MedicalRecord> listMedicalRecords(String patientID);
}
