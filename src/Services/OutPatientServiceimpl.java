package Services;


import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnectionUtil.DBConnection;
import Model.OutPatient;

public class OutPatientServiceimpl implements IOutPatientService, GenerateIDs {

	public static Connection conn;
	private PreparedStatement ps;
	
	//Generate OutPatient IDs
	@Override
	public String generateIDs(ArrayList<String> arraylist) {
		
		String outPatientID = "OPD100";
		
		String o_Pid;
		int count = arraylist.size();
		count++;
		o_Pid = outPatientID + count;
		if (arraylist.contains(o_Pid)) {
			count++;
			o_Pid = outPatientID + count;
		}
		return o_Pid;
	}
	
	
	
	@Override
	public ArrayList<String> getOutPatientID() {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		String outPATIENTBYID_SQL = "SELECT o.outPatientID FROM OutPatient AS o";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(outPATIENTBYID_SQL);	
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
	public void AddOutPatient(OutPatient out_Patient){
		
		String add_OUTPATIENT_SQL = "INSERT INTO OutPatient(outPatientID,firstName,lastName,age,gender,phone,"
				+ "email,address,password) values (?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBConnection.getDBConnection();
			ps = conn.prepareStatement(add_OUTPATIENT_SQL);
		
			String outPatientID = generateIDs(getOutPatientID());
		
			ps.setString(1, outPatientID);
			ps.setString(2, out_Patient.getFirstName());
			ps.setString(3, out_Patient.getLastName());
			ps.setInt(4,out_Patient.getAge());
			ps.setString(5, out_Patient.getGender());
			ps.setString(6, out_Patient.getPhone());
			ps.setString(7, out_Patient.getEmail());
			ps.setString(8, out_Patient.getAddress());
			ps.setString(9, out_Patient.getPassword());
			ps.executeUpdate();
			
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
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
	public OutPatient getOutPatientByID(String outPatientID) {
		
		OutPatient out_patient = new OutPatient();
		
		String getpatient = "SELECT* FROM OutPatient WHERE outPatientID = ? ;";
		
		try
		{
			conn = DBConnection.getDBConnection();		
			
			if(outPatientID != null && !outPatientID.isEmpty())
			{
				ps = conn.prepareStatement(getpatient);
				ps.setString(1, outPatientID);
				System.out.println(outPatientID);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					out_patient.setOutPatientID(rs.getString(1));
					out_patient.setFirstName(rs.getString(2));
					out_patient.setLastName(rs.getString(3));
					out_patient.setAge(rs.getInt(4));
					out_patient.setGender(rs.getString(5));
					out_patient.setPhone(rs.getString(6));
					out_patient.setEmail(rs.getString(7));
					out_patient.setAddress(rs.getString(8));
					out_patient.setPassword(rs.getString(9));
				}
				conn.close();
			}	
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
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
	
		
		return out_patient;
	}

	
	
	
	
	//IT19127088 Senarathna A.M.M.D.N
	
	@Override
	public OutPatient UpdateOutPatient(String outPatientID,OutPatient out_Patient) {
		
		String updatepatient = "UPDATE OutPatient SET firstName=?, lastName=?, age=?, gender=?, phone=?,"
				+ "email=?, address=?, password=? WHERE outPatientID = ?";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(updatepatient);
		
			ps.setString(1, out_Patient.getFirstName());
			ps.setString(2, out_Patient.getLastName());
			ps.setInt(3,out_Patient.getAge());
			ps.setString(4, out_Patient.getGender());
			ps.setString(5, out_Patient.getPhone());
			ps.setString(6, out_Patient.getEmail());
			ps.setString(7, out_Patient.getAddress());
			ps.setString(8, out_Patient.getPassword());
			ps.setString(9, outPatientID);
			ps.executeUpdate();
		
			
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
		}catch(Exception e) {
			System.out.println(e);
		}
	
		
		return getOutPatientByID(outPatientID);
	}

	
	@Override
	public ArrayList<OutPatient> listOutPatients() {
		
		ArrayList<OutPatient> out_Patientlist = new ArrayList<OutPatient>();
		String patientlist = "SELECT * FROM OutPatient";
		
		try {
			conn = DBConnection.getDBConnection();
			PreparedStatement ps = conn.prepareStatement(patientlist);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				OutPatient out_patient = new OutPatient();
				out_patient.setOutPatientID(rs.getString(1));
				out_patient.setFirstName(rs.getString(2));
				out_patient.setLastName(rs.getString(3));
				out_patient.setAge(rs.getInt(4));
				out_patient.setGender(rs.getString(5));
				out_patient.setPhone(rs.getString(6));
				out_patient.setEmail(rs.getString(7));
				out_patient.setAddress(rs.getString(8));
				out_patient.setPassword(rs.getString(9));
				out_Patientlist.add(out_patient);
				
				
			}
			conn.close();
			
		}catch(SQLException|ClassNotFoundException ex)
		{
			System.out.println(ex);
		}
		
		return out_Patientlist;
	}


	@Override
	public void deleteOutPatient(String outPatientID) {
		
		String delete = "DELETE FROM OutPatient WHERE OutPatientID = ?";
		
		if(outPatientID != null && !outPatientID.isEmpty()) {
			try {
				conn = DBConnection.getDBConnection();
				PreparedStatement ps = conn.prepareStatement(delete);
				ps.setString(1, outPatientID);
				ps.executeUpdate();
				
			}catch(SQLException|ClassNotFoundException ex)
			{
				System.out.println(ex);
			}
		
		}
		
	}


}
