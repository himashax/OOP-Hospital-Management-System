package Model;


public class Appointments {

	private String appID;
	
	private String out_patientID;
	
	private String doctorID;
	
	private String date;
	

	/**
	 * @return the appID
	 */
	public String getAppID() {
		return appID;
	}


	/**
	 * @param appID the appID to set
	 */
	
	public void setAppID(String appID) {
		this.appID = appID;
	}

	/**
	 * @return the out_patientID
	 */
	public String getOut_patientID() {
		return out_patientID;
	}

	/**
	 * @param out_patientID the out_patientID to set
	 */
	
	public void setOut_patientID(String out_patientID) {
		this.out_patientID = out_patientID;
	}

	/**
	 * @return the doctorID
	 */
	public String getDoctorID() {
		return doctorID;
	}

	/**
	 * @param doctorID the doctorID to set
	 */
	
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	
	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Appointments [appID=" + appID + ", out_patientID=" + out_patientID + ", doctorID=" + doctorID
				+ ", date=" + date + "]";
	}


	

	
	
	
	
	
}
