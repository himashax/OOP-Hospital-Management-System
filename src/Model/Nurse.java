package Model;

public class Nurse extends Employee{

	private String nurseID;

	
	public String getNurseID() {
		return nurseID;
	}

	public void setNurseID(String nurseID) {
		this.nurseID = nurseID;
	}

	@Override
	public String toString() {

		return "Nurse ID " +nurseID+ "\n" + "First Name " +getFirstName()+ "\n" +"Last Name" +getLastName()+ "\n" + "Age " +getAge()+ "\n" + "Gender " +getGender()+ "\n" + "Phone " +getPhone()+ "\n" 
		+ "Email " +getEmail()+ "\n" + "Address " +getAddress()+ "\n" + "Salary " +getSalary()+ "\n" + "Password " +getPassword();
	}
}
