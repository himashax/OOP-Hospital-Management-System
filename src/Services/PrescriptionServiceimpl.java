package Services;



//This class implements the IPrescriptionService and GenerateIDs interfaces

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnectionUtil.DBConnection;
import Model.Prescription;

public class PrescriptionServiceimpl implements IPrescriptionService, GenerateIDs {

	public static Connection conn;
	private PreparedStatement ps;
	
	@Override
	public String generateIDs(ArrayList<String> arraylist) {

		String prescriptionID = "PID200";

		String presID;
		int count = arraylist.size();
		count++;
		presID = prescriptionID + count;
		if (arraylist.contains(presID)) {
			count++;
			presID = prescriptionID + count;
		}
		
		//generate ids for presceiptions
		return presID;

	}

	
	public ArrayList<String> getPrescriptionID() {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		String prescriptionID_sql = "SELECT p.presID FROM Prescription AS p";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(prescriptionID_sql);	
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				arrayList.add(rs.getString(1));	
			}
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return arrayList;
	}


	@Override
	public void AddPrescription(Prescription prescription) {
		
		String addPrescrption_sql = "INSERT INTO Prescription(presID,name,dose,patientID,doctorID) values (?,?,?,?,?)";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(addPrescrption_sql);
		
			//generate id and assign i to the prescription id
			String prescriptionID = generateIDs(getPrescriptionID());
		
			ps.setString(1, prescriptionID);
			ps.setString(2, prescription.getName());
			ps.setString(3, prescription.getDose());
			ps.setString(4,prescription.getPatientID());
			ps.setString(5, prescription.getDoctorID());
			ps.executeUpdate();
			
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
		}catch(Exception e) {
			System.out.println(e);
		}	
		finally {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}}
		
		
	}

	@Override
	public Prescription getPrescription(String presID) {
		
		Prescription prescription = new Prescription();
		
		String getPrescription_sql = "SELECT * FROM Prescription WHERE presID = ? ";
		
		try {
			conn = DBConnection.getDBConnection();
			
			if(presID != null && presID.isEmpty())
			{
				ps = conn.prepareStatement(getPrescription_sql);
				ps.setString(1, presID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					prescription.setPrescriptionID(rs.getString(1));
					prescription.setName(rs.getString(2));
					prescription.setDose(rs.getString(3));
					prescription.setPatientID(rs.getString(4));
					prescription.setDoctorID(rs.getString(5));
				}
				conn.close();
			}
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}}
		
		//return prescription details of he patient for the given patient id
		return prescription;
	}


	@Override
	public Prescription UpdatePrescription(String presID, Prescription prescription) {
		
		String updatePrescription_sql = "UPDATE Prescription SET name = ?, dose = ? WHERE presID = ? ";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(updatePrescription_sql);
			
			ps.setString(1, prescription.getName());
			ps.setString(2, prescription.getDose());
			ps.setString(3, prescription.getDoctorID());
			ps.setString(4, prescription.getPrescriptionID());
			ps.setString(5, prescription.getPatientID());
			ps.executeUpdate();
			
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		}
		
		//update and return updated prescription
		return getPrescription(presID);	
	}


	@Override
	public ArrayList<Prescription> listPrescriptions(String patient_id) {

		ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
		String listPrescriptions_sql = "SELECT * FROM Prescription where patientID = ?";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(listPrescriptions_sql);
			ps.setString(1, patient_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Prescription prescription = new Prescription();
				prescription.setPrescriptionID(rs.getString(1));
				prescription.setName(rs.getString(2));
				prescription.setDose(rs.getString(3));
				prescription.setDoctorID(rs.getString(5));
				prescriptions.add(prescription);
			}
			conn.close();
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}}
		
		//return the list of prescriptions relevant to the patient for the given patient id
		return prescriptions;
	}

	

	















}





