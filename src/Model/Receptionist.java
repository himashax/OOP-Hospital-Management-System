package Model;

public class Receptionist extends Employee {

	String receptionistID;

	public String getReceptionistID() {
		return receptionistID;
	}

	public void setReceptionistID(String receptionistID) {
		this.receptionistID = receptionistID;
	}

	@Override
	public String toString() {
		return "Receptionist ID " +receptionistID+ "\n" + "First Name " +getFirstName()+ "\n" +"Last Name" +getLastName()+ "\n" + "Age " +getAge()+ "\n" + "Gender " +getGender()+ "\n" + "Phone " +getPhone()+ "\n" 
				+ "Email " +getEmail()+ "\n" + "Address " +getAddress()+ "\n" + "Salary " +getSalary()+ "\n" + "Password " +getPassword();
	}
	
	
}
