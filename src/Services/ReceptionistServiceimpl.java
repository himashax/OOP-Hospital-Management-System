package Services;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnectionUtil.DBConnection;
import Model.Receptionist;

public class ReceptionistServiceimpl implements IReceptionistService {
	
	public static Connection conn;

	
	//add receptionist
	@Override
	public void addReceptionist(Receptionist receptionist) {
		
		String addReceptionist = "INSERT INTO Receptionist(recepID,firstName,lastName,age,gender,phone,"
				+ "email,address,salary,password) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(addReceptionist);
		
			ps.setString(1, receptionist.getReceptionistID());
			ps.setString(2, receptionist.getFirstName());
			ps.setString(3, receptionist.getLastName());
			ps.setInt(4,receptionist.getAge());
			ps.setString(5, receptionist.getGender());
			ps.setString(6, receptionist.getPhone());
			ps.setString(7, receptionist.getEmail());
			ps.setString(8, receptionist.getAddress());
			ps.setDouble(9, receptionist.getSalary());
			ps.setString(10, receptionist.getPassword());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	
	//update receptionist
	@Override
	public Receptionist updateReceptionist(String recepID, Receptionist receptionist) {
		
		String updateReceptionist = "UPDATE Receptionist SET firstName=?, lastName=?, age=?, gender=?, phone=?,"
				+ "email=?, address=?,salary=?, password=? WHERE recepID = ?";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(updateReceptionist);
		
			ps.setString(1, receptionist.getFirstName());
			ps.setString(2, receptionist.getLastName());
			ps.setInt(3,receptionist.getAge());
			ps.setString(4, receptionist.getGender());
			ps.setString(5, receptionist.getPhone());
			ps.setString(6, receptionist.getEmail());
			ps.setString(7, receptionist.getAddress());
			ps.setDouble(8, receptionist.getSalary());
			ps.setString(9, receptionist.getPassword());
			ps.setString(10, recepID);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		//return updates receptionist
		return getReceptionist(recepID);
	}

	
	//select receptionist by receptionist's id
	@Override
	public Receptionist getReceptionist(String recepID) {

		Receptionist receptionist = new Receptionist();
		
		String getReceptionist = "SELECT* FROM Receptionist WHERE recepID = ?";
		
		try
		{
			conn = DBConnection.getDBConnection();		
			
			if(recepID != null && !recepID.isEmpty())
			{
				PreparedStatement ps = conn.prepareStatement(getReceptionist);
				ps.setString(1, recepID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					receptionist.setReceptionistID(rs.getString(1));
					receptionist.setFirstName(rs.getString(2));
					receptionist.setLastName(rs.getString(3));
					receptionist.setAge(rs.getInt(4));
					receptionist.setGender(rs.getString(5));
					receptionist.setPhone(rs.getString(6));
					receptionist.setEmail(rs.getString(7));
					receptionist.setAddress(rs.getString(8));
					receptionist.setSalary(rs.getDouble(9));
					receptionist.setPassword(rs.getString(10));
				}
				conn.close();
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return receptionist;
	}

	
	//delete receptionist
	@Override
	public void deleteReceptionist(String recepID) {
		
		String delReceptionist = "DELETE FROM Receptionist WHERE recepID = ?";
		
		if(recepID != null && !recepID.isEmpty()) {
			try {
				conn = DBConnection.getDBConnection();
				PreparedStatement ps = conn.prepareStatement(delReceptionist);
				ps.setString(1, recepID);
				ps.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
	
	//list all receptionists
	@Override
	public ArrayList<Receptionist> listReceptionists() {
		
		ArrayList<Receptionist> receptionistList = new ArrayList<Receptionist>();
		String listReceptionists = "SELECT * FROM Receptionist";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(listReceptionists);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Receptionist receptionist = new Receptionist();
				receptionist.setReceptionistID(rs.getString(1));
				receptionist.setFirstName(rs.getString(2));
				receptionist.setLastName(rs.getString(3));
				receptionist.setAge(rs.getInt(4));
				receptionist.setGender(rs.getString(5));
				receptionist.setPhone(rs.getString(6));
				receptionist.setEmail(rs.getString(7));
				receptionist.setAddress(rs.getString(8));
				receptionist.setSalary(rs.getDouble(9));
				receptionist.setPassword(rs.getString(10));
				receptionistList.add(receptionist);
				
			}
			conn.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return receptionistList;
	}
	
	
}
