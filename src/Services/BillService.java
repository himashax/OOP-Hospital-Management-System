package Services;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import DBConnectionUtil.DBConnection;
import Model.Bill;

public class BillService {

	public static Connection conn;
	
	
	//serach bill amount using ids 
	public Bill validate(String patientid , String billid) {
		
		Bill bill = null;
		
		try {
			
			conn = DBConnection.getDBConnection();
			PreparedStatement psStatement = conn.prepareStatement("SELECT * FROM Bill where PatientID = ? and BillID = ?");
			psStatement.setString(1, patientid);
			psStatement.setString(2, billid);
			
			ResultSet resultSet = psStatement.executeQuery();
			
			
			while(resultSet.next()) {
				
				String patient = resultSet.getString("PatientID");
				String bill_id = resultSet.getString("BillID");
				int amm = resultSet.getInt("Amount");
				
				bill = new Bill(patient, bill_id, amm);
				
				System.out.println(patient);
				System.out.println(bill);
				System.out.println(amm);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		 
		return bill;
		
	}
	
	
	//add bill
	public int insertbill(String pid , String bid , int ammo) {
		
		int isSuccess = 0;
		
		System.out.println(pid);
		
		try {

			conn = DBConnection.getDBConnection();
			PreparedStatement psStatement = conn.prepareStatement("INSERT INTO Bill (`PatientID`, `BillID`, `Amount`) VALUES (?,?,?)");
			psStatement.setString(1, pid);
			psStatement.setString(2, bid);
			psStatement.setInt(3, ammo);
			
			System.out.println(pid);
			
			isSuccess = psStatement.executeUpdate();
			System.out.println(isSuccess);

		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return isSuccess;
		
		
	}
	
	
	//update bill amount using the ids when given
	public int updateBill(int amm, String billid) {
		
		int result = 0;
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("UPDATE Bill SET `Amount` = ? WHERE (`BillID` = ?)");
			preparedStatement.setInt(1, amm);
			preparedStatement.setString(2, billid);
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
		
	}
	
		//delete bill
		public int delUser(String billid) {
		
		int result = 0;
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Bill WHERE `BillID` = ? ");
			preparedStatement.setString(1, billid);
			result = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
		
	
}
