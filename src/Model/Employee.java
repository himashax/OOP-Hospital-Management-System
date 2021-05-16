package Model;

//IT19128696 Mandakini G.H
//Employee abstract class

abstract class Employee {
	
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String phone;
	private String email;
	private String address;
	private double salary;
	private String password;
	
	
	/**
	 * @return the employeeID
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param employeeID the employeeID to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param phone the email to email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "First Name " + getFirstName() + "\n" + "Last Name " + getLastName() + "\n" +"Age " + getAge() + "\n" 
				+ "Gender " + getGender() + "\n" + "Phone " + getPhone() + "\n" + "Email Address" + getEmail() + "\n" + "Address " + getAddress() + "\n" + "Salary " + getSalary() + "\n" + "Password " + getPassword();
	};

	
}
