package Services;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnectionUtil.DBConnection;
import Model.Appointments;
import Model.MedicalRecord;

public class MedicalRecordServiceimpl implements IMedicalRecordService{

	public static Connection conn;
	
	
	//add medical records
	public void addMedcalRecord(MedicalRecord medicalRecord)
	{
		String addMedicalRecord_sql = "INSERT INTO MedicalRecord(medRecordID, symptoms, observation, diagnosis,notes,patientID,doctorID)"
				+ " VALUES (?,?,?,?,?,?,?) ";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(addMedicalRecord_sql);
			
			ps.setString(1, medicalRecord.getMedRecordID());
			ps.setString(2, medicalRecord.getSymptoms());
			ps.setString(3, medicalRecord.getObservation());
			ps.setString(4, medicalRecord.getDiagnosis());
			ps.setString(5, medicalRecord.getNotes());
			ps.setString(6, medicalRecord.getPatientID());
			ps.setString(7, medicalRecord.getDoctorID());
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	//select medical record and get details
	public MedicalRecord getMedicalRecords(String patientID) {
		
		MedicalRecord medicalRecord = new MedicalRecord();
		
		String getMedicalRecord_sql = "SELECT* FROM MedicalRecord WHERE patientID = ?";
		
		try
		{
			conn = DBConnection.getDBConnection();		
			
			if(patientID != null && !patientID.isEmpty())
			{
				PreparedStatement ps = conn.prepareStatement(getMedicalRecord_sql);
				ps.setString(1, patientID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					medicalRecord.setMedRecordID(rs.getString(1));
					medicalRecord.setSymptoms(rs.getString(2));
					medicalRecord.setObservation(rs.getString(3));
					medicalRecord.setDiagnosis(rs.getString(4));;
					medicalRecord.setNotes(rs.getString(5));
					medicalRecord.setPatientID(rs.getString(6));
					medicalRecord.setDoctorID(rs.getString(7));	
				}
				conn.close();
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return medicalRecord;
	}
	
	//update medical records
	public MedicalRecord updateMedicalRecord(String medRecordID, MedicalRecord medicalRecord) {
		
		String updateMedicalRecord_sql = "UPDATE MedicalRecord SET symptoms = ? , observation = ?, diagnosis = ?, "
										+ "notes = ? , patientID = ?,  doctorID = ?  WHERE medRecordID = ? ";
		
		System.out.println("again help" + medRecordID);
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(updateMedicalRecord_sql);
		
			ps.setString(1, medicalRecord.getSymptoms());
			ps.setString(2, medicalRecord.getObservation());
			ps.setString(3,medicalRecord.getDiagnosis());
			ps.setString(4, medicalRecord.getNotes());
			ps.setString(7, medicalRecord.getPatientID());
			ps.setString(5, medicalRecord.getDoctorID());
			ps.setString(6, medicalRecord.getMedRecordID());
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return getMedicalRecords(medRecordID);
	}
	
	
	//medical records list for the patient
	public ArrayList<MedicalRecord> listMedicalRecords(String patientID) {
		
		ArrayList<MedicalRecord> medRecordList = new ArrayList<MedicalRecord>();
		String listMedicalRecords_sql = "SELECT * FROM MedicalRecord where patientID = ?";
		System.out.println(patientID);
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(listMedicalRecords_sql);
			ps.setString(1, patientID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				MedicalRecord medRecord = new MedicalRecord();
				medRecord.setMedRecordID(rs.getString(1));
				medRecord.setSymptoms(rs.getString(2));
				medRecord.setObservation(rs.getString(3));
				medRecord.setDiagnosis(rs.getString(4));
				medRecord.setNotes(rs.getString(5));
				medRecord.setDoctorID(rs.getString(7));
				medRecordList.add(medRecord);
				
			}
			conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return medRecordList;
	}
	
}
