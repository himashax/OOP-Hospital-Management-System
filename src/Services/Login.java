package Services;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import DBConnectionUtil.DBConnection;
import Model.OutPatient;

public class Login {

	public static Connection conn;
	
	
	
	/* This method checks for different users who logins to the system 
	       and validate the login details by sending data to tables relevant to the user using conditions*/
	
		public boolean ValidateUser(String userID, String password, String userType)
		{	;
			String validatePatient_SQL = "SELECT * FROM OutPatient WHERE outPatientID = ? and password = ? ";
			String validateDoctor_SQL = "SELECT * FROM Doctor WHERE doctorID = ? and password = ? ";
			String validateNurse_SQL = "SELECT * FROM Nurse WHERE nurseID = ? and password = ? ";
			String validateReceptionist_SQL = "SELECT * FROM Receptionist WHERE recepID = ? and password = ? ";
			String validateAdmin_SQL = "SELECT * FROM Admin WHERE adminID = ? and password = ? ";
			
			ResultSet rs = null;
			
			try {
				conn = DBConnection.getDBConnection();
				
				//validation of patient if the user type is patient
				if(userID != null && !userID.isEmpty() && password != null && !password.isEmpty() && userType.equals("patient")){
					PreparedStatement ps = conn.prepareStatement(validatePatient_SQL);
					ps.setString(1, userID);
					ps.setString(2, password);
					rs = ps.executeQuery();
				}
				
				//validation of doctor if the user type is doctor
				else if(userID != null && !userID.isEmpty() && password != null && !password.isEmpty() && userType.equals("doctor"))
				{
					PreparedStatement ps = conn.prepareStatement(validateDoctor_SQL);
					ps.setString(1, userID);
					ps.setString(2, password);
					rs = ps.executeQuery();
				
				}
				
				//validation of nurse if the user type is nurse
				else if(userID != null && !userID.isEmpty() && password != null && !password.isEmpty() && userType.equals("nurse")) {
					PreparedStatement ps = conn.prepareStatement(validateNurse_SQL);
					ps.setString(1, userID);
					ps.setString(2, password);
					rs = ps.executeQuery();
					
				}
				
				//validation of receptionist if the user type is receptionist
				else if(userID != null && !userID.isEmpty() && password != null && !password.isEmpty() && userType.equals("receptionist"))
				{
					PreparedStatement ps = conn.prepareStatement(validateReceptionist_SQL);
					ps.setString(1, userID);
					ps.setString(2, password);
					rs = ps.executeQuery();
				}
				
				//validation of admin if the user type is admin
				else if(userID != null && !userID.isEmpty() && password != null && !password.isEmpty() && userType.equals("admin")) {
					PreparedStatement ps = conn.prepareStatement(validateAdmin_SQL);
					ps.setString(1, userID);
					ps.setString(2, password);
					rs = ps.executeQuery();
				}
				
				if(rs.next())
				{
					return true;
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception ex){
				System.out.println(ex);
			}
			
			return false;
			}

}
