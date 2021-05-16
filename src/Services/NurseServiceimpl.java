package Services;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnectionUtil.DBConnection;
import Model.Nurse;

public class NurseServiceimpl implements INurseService{

	public static Connection conn;
	
	
	//add nurse to the  sysytem
	
	@Override
	public void addNurse(Nurse nurse) {

		String addNurse_sql = "INSERT INTO Nurse(nurseID,firstName,lastName,age,gender,phone,"
				+ "email,address,salary,password) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(addNurse_sql);
		
			ps.setString(1, nurse.getNurseID());
			ps.setString(2, nurse.getFirstName());
			ps.setString(3, nurse.getLastName());
			ps.setInt(4,nurse.getAge());
			ps.setString(5, nurse.getGender());
			ps.setString(6, nurse.getPhone());
			ps.setString(7, nurse.getEmail());
			ps.setString(8, nurse.getAddress());
			ps.setDouble(9, nurse.getSalary());
			ps.setString(10, nurse.getPassword());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}

	
	//retreive nurse's details
	@Override
	public Nurse getNurse(String nurseID) {
		
		Nurse nurse = new Nurse();
		
		String getNurse_sql = "SELECT* FROM Nurse WHERE nurseID = ?";
		
		try
		{
			conn = DBConnection.getDBConnection();		
			
			if(nurseID != null && !nurseID.isEmpty())
			{
				PreparedStatement ps = conn.prepareStatement(getNurse_sql);
				ps.setString(1, nurseID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					nurse.setNurseID(rs.getString(1));
					nurse.setFirstName(rs.getString(2));
					nurse.setLastName(rs.getString(3));
					nurse.setAge(rs.getInt(4));
					nurse.setGender(rs.getString(5));
					nurse.setPhone(rs.getString(6));
					nurse.setEmail(rs.getString(7));
					nurse.setAddress(rs.getString(8));
					nurse.setSalary(rs.getDouble(9));
					nurse.setPassword(rs.getString(10));
				}
				conn.close();
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return nurse;
		
	}

	//update nurse's details for given nurse id
	@Override
	public Nurse updateNurse(String nurseID, Nurse nurse) {
		
		String updateNurse_sql = "UPDATE Nurse SET firstName=?, lastName=?, age=?, gender=?, phone=?,"
				+ "email=?, address=?,salary=?, password=? WHERE nurseID = ?";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(updateNurse_sql);
		
			ps.setString(1, nurse.getFirstName());
			ps.setString(2, nurse.getLastName());
			ps.setInt(3,nurse.getAge());
			ps.setString(4, nurse.getGender());
			ps.setString(5, nurse.getPhone());
			ps.setString(6, nurse.getEmail());
			ps.setString(7, nurse.getAddress());
			ps.setDouble(8, nurse.getSalary());
			ps.setString(9, nurse.getPassword());
			ps.setString(10, nurseID);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return getNurse(nurseID);
	}

	//delete nurse from the system
	@Override
	public void deleteNurse(String nurseID) {
		
		String deleteNurse_sql = "DELETE FROM Nurse WHERE nurseID = ?";
		
		if(nurseID != null && !nurseID.isEmpty()) {
			try {
				conn = DBConnection.getDBConnection();
				PreparedStatement ps = conn.prepareStatement(deleteNurse_sql);
				ps.setString(1, nurseID);
				ps.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}

	
	//nurse list
	
	@Override
	public ArrayList<Nurse> listNurses() {
		
		ArrayList<Nurse> nurselist = new ArrayList<Nurse>();
		String listNurses_sql = "SELECT * FROM Nurse";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(listNurses_sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Nurse nurse = new Nurse();
				nurse.setNurseID(rs.getString(1));
				nurse.setFirstName(rs.getString(2));
				nurse.setLastName(rs.getString(3));
				nurse.setAge(rs.getInt(4));
				nurse.setGender(rs.getString(5));
				nurse.setPhone(rs.getString(6));
				nurse.setEmail(rs.getString(7));
				nurse.setAddress(rs.getString(8));
				nurse.setSalary(rs.getDouble(9));
				nurse.setPassword(rs.getString(10));
				nurselist.add(nurse);
				
			}
			conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return nurselist;
	}

}
