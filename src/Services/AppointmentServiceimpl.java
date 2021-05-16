package Services;

//IT19128696 

//This class implements the IAppointmentService and GenerateIDs interfaces
//This class is used to implement the CRUD operations and other methods for Appointment class

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

import DBConnectionUtil.DBConnection;
import Model.Appointments;


public class AppointmentServiceimpl implements IAppointmentService, GenerateIDs {

	public static Connection conn;
	private PreparedStatement ps;
	
	
	
	@Override
	public String generateIDs(ArrayList<String> arraylist) {
		
		//Generate Appointment IDs
		String appID = "APP501";
		
		String app_id;
		int count = arraylist.size();
		count++;
		app_id = appID + count;
		if (arraylist.contains(app_id)) {
			count++;
			app_id = appID + count;
		}
		return app_id;
	}
	
	
	
	@Override
	public ArrayList<String> getAppointmentID() {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		String appointmentBYID_SQL = "SELECT a.appID FROM Appointment AS a";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(appointmentBYID_SQL);	
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
		
		//Get all list of employees
		return arrayList;
	}
	
	
	
	@Override
	public void addAppointment(Appointments appointment)
	{
		String addAPPOINTMENT_SQL = "INSERT INTO Appointment(appID,patientID,doctorID,appdate) VALUES (?,?,?,?) ";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(addAPPOINTMENT_SQL);
			
			String appID = generateIDs(getAppointmentID());
			ps.setString(1, appID);
			ps.setString(2, appointment.getOut_patientID());
			ps.setString(3, appointment.getDoctorID());
			ps.setString(4, appointment.getDate());
			ps.executeUpdate();
			//add appointments
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
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
	public Appointments getAppointments(String appID) {
		
		Appointments appointment = new Appointments();
		
		String getAPPOINTMENT_SQL = "SELECT* FROM Appointment WHERE appID = ?";
		
		try
		{
			conn = DBConnection.getDBConnection();		
			
			if(appID != null && !appID.isEmpty())
			{
				PreparedStatement ps = conn.prepareStatement(getAPPOINTMENT_SQL);
				ps.setString(1, appID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					appointment.setAppID(rs.getString(1));
					appointment.setOut_patientID(rs.getString(2));
					appointment.setDoctorID(rs.getString(3));
					appointment.setDate(rs.getString(4));
				
				}
			}	
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
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
		//return appointment details for the given appointment id
		return appointment;
	}

	
	@Override
	public Appointments updateAppointment(String appID, Appointments appointment) {
		
		String updateAPPOINTMENT_SQL = "UPDATE Appointment SET patientID = ?, doctorID = ? , appDate = ? WHERE appID = ?";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(updateAPPOINTMENT_SQL);
		
			ps.setString(1, appointment.getOut_patientID());
			ps.setString(2, appointment.getDoctorID());
			ps.setString(3,appointment.getDate());
			ps.setString(4, appointment.getAppID());
		
			ps.executeUpdate();
			
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
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
		
		//update appointments for the given id
		return getAppointments(appID);
	}


	@Override
	public void deleteAppointment(String appID) {
		
		String deleteAppointment_sql = "DELETE FROM Appointment WHERE appID = ?";
		
		if(appID != null && !appID.isEmpty()) {
			try {
				conn = DBConnection.getDBConnection();
				PreparedStatement ps = conn.prepareStatement(deleteAppointment_sql);
				ps.setString(1, appID);
				ps.executeUpdate();
				
				//delete appointments for the given appointment id
				
			}catch(SQLException|ClassNotFoundException e) {
				e.printStackTrace();
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
	public ArrayList<Appointments> listAppointments() {
		
		ArrayList<Appointments> appointmentList = new ArrayList<Appointments>();
		String listAppointments_sql = "SELECT * FROM Appointment";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(listAppointments_sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Appointments appointment = new Appointments();
				appointment.setAppID(rs.getString(1));
				appointment.setOut_patientID(rs.getString(2));
				appointment.setDoctorID(rs.getString(3));
				appointment.setDate(rs.getString(4));
				appointmentList.add(appointment);
				
			}
			conn.close();
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
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
		
		//return the list of appointments
		return appointmentList;
	}
	
	@Override
	public ArrayList<Appointments> listAppointmentsPatient(String patientID) {
		
		ArrayList<Appointments> appointmentList = new ArrayList<Appointments>();
		String listAppointments_sql = "SELECT * FROM Appointment where patientID = ?";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(listAppointments_sql);
			ps.setString(1, patientID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Appointments appointment = new Appointments();
				appointment.setAppID(rs.getString(1));
				appointment.setDoctorID(rs.getString(3));
				appointment.setDate(rs.getString(4));
				appointmentList.add(appointment);
				
			}
			conn.close();
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
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
		
		//return the list of appointments to the relevant patient for the given patient id
		return appointmentList;
	}

	@Override
	public ArrayList<Appointments> listAppointmentsDoctor(String doctorID) {
		
		ArrayList<Appointments> appointmentList = new ArrayList<Appointments>();
		String listAppointments_sql = "SELECT * FROM Appointment where doctorID = ?";
		System.out.println(doctorID);
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(listAppointments_sql);
			ps.setString(1, doctorID);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Appointments appointment = new Appointments();
				appointment.setAppID(rs.getString(1));
				appointment.setOut_patientID(rs.getString(2));
				appointment.setDate(rs.getString(4));
				appointmentList.add(appointment);
				
			}
			conn.close();
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
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
		
		//return the list of appointments relevant to the doctor for the given doctor id
		return appointmentList;
	}
	
	
	
}



