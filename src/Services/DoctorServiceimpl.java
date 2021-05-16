package Services;

//IT19128696 
//This class implements the IDoctorService and GenerateIDs interfaces
//This class is used to implement the CRUD operations and other methods for Doctor class

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnectionUtil.DBConnection;
import Model.Doctor;


public class DoctorServiceimpl implements IDoctorService,GenerateIDs{

	public static Connection conn;
	private PreparedStatement ps;
	
	@Override
	public String generateIDs(ArrayList<String> arraylist) {
		String docID = "DOC300";
		
		String doc_id;
		int count = arraylist.size();
		count++;
		doc_id = docID + count;
		if (arraylist.contains(doc_id)) {
			count++;
			doc_id = docID + count;
		}
		
		//generate and return the doctor id
		return doc_id;
	}
	
	
	@Override
	public ArrayList<String> getDoctorID() {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		String doctorByID_SQL = "SELECT d.doctorID FROM Doctor AS d";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(doctorByID_SQL);	
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
		//get all list of doctors
		return arrayList;
	}
	
	
	
	@Override
	public void addDoctor(Doctor doctor) {
		
		String addDOCTOR_SQL = "INSERT INTO Doctor(doctorID,firstName,lastName,age,gender,phone,"
				+ "email,address,salary,password) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(addDOCTOR_SQL);
		
			String doctor_id = generateIDs(getDoctorID());
			ps.setString(1, doctor_id);
			ps.setString(2, doctor.getFirstName());
			ps.setString(3, doctor.getLastName());
			ps.setInt(4,doctor.getAge());
			ps.setString(5, doctor.getGender());
			ps.setString(6, doctor.getPhone());
			ps.setString(7, doctor.getEmail());
			ps.setString(8, doctor.getAddress());
			ps.setDouble(9, doctor.getSalary());
			ps.setString(10, doctor.getPassword());
			ps.executeUpdate();
			
			//add doctors
			
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
	}

	
	
	@Override
	public Doctor getDoctor(String doctorID) {
		
        Doctor doctor = new Doctor();
		
		String getDOCTOR_SQL = "SELECT* FROM Doctor WHERE doctorID = ?";
		
		try
		{
			conn = DBConnection.getDBConnection();		
			
			if(doctorID != null && !doctorID.isEmpty())
			{
				ps = conn.prepareStatement(getDOCTOR_SQL);
				ps.setString(1, doctorID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					doctor.setDoctorID(rs.getString(1));
					doctor.setFirstName(rs.getString(2));
					doctor.setLastName(rs.getString(3));
					doctor.setAge(rs.getInt(4));
					doctor.setGender(rs.getString(5));
					doctor.setPhone(rs.getString(6));
					doctor.setEmail(rs.getString(7));
					doctor.setAddress(rs.getString(8));
					doctor.setSalary(rs.getDouble(9));
					doctor.setPassword(rs.getString(10));
				}
				
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
		}
		}
		
		//return the doctor details for the given doctor id
		return doctor;
	}

	@Override
	public Doctor updateDoctor(String doctorID, Doctor doctor) {
		
		String updateDOCTOR_SQL = "UPDATE Doctor SET firstName=?, lastName=?, age=?, gender=?, phone=?,"
				+ "email=?, address=?,salary=?, password=? WHERE doctorID = ?";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(updateDOCTOR_SQL);
		
			ps.setString(1, doctor.getFirstName());
			ps.setString(2, doctor.getLastName());
			ps.setInt(3,doctor.getAge());
			ps.setString(4, doctor.getGender());
			ps.setString(5, doctor.getPhone());
			ps.setString(6, doctor.getEmail());
			ps.setString(7, doctor.getAddress());
			ps.setDouble(8, doctor.getSalary());
			ps.setString(9, doctor.getPassword());
			ps.setString(10, doctorID);
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
		//return updated doctor details
		return getDoctor(doctorID);
	}

	@Override
	public void deleteDoctor(String doctorID) {
		
		String deleteDOCTOR_SQL = "DELETE FROM Doctor WHERE doctorID = ?";
		
		if(doctorID != null && !doctorID.isEmpty()) {
			try {
				conn = DBConnection.getDBConnection();
				ps = conn.prepareStatement(deleteDOCTOR_SQL);
				ps.setString(1, doctorID);
				ps.executeUpdate();
				
				//delete the doctor for the given doctor id
				
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
		}
	}

	@Override
	public ArrayList<Doctor> listDoctors() {
		
		ArrayList<Doctor> doctorlist = new ArrayList<Doctor>();
		String listDOCTORS_SQL = "SELECT * FROM Doctor";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(listDOCTORS_SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Doctor doctor = new Doctor();
				doctor.setDoctorID(rs.getString(1));
				doctor.setFirstName(rs.getString(2));
				doctor.setLastName(rs.getString(3));
				doctor.setAge(rs.getInt(4));
				doctor.setGender(rs.getString(5));
				doctor.setPhone(rs.getString(6));
				doctor.setEmail(rs.getString(7));
				doctor.setAddress(rs.getString(8));
				doctor.setSalary(rs.getDouble(9));
				doctor.setPassword(rs.getString(10));
				doctorlist.add(doctor);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
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
		//return the list of doctors
		return doctorlist;
	}
	
	
}
