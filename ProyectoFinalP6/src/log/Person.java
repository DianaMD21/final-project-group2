package log;

import java.util.Date;

public abstract class Person {
	
	protected String id;	
	protected String name;
	protected String lastName;
	protected Date birthDate;
	protected String address;
	protected String email;
	protected String province;
	protected String city;
	protected String gender;
	protected String maritalStatus;
	protected String phoneNumber;
	protected boolean workingStatus;
	
	public Person(String id, String name, String lastName, Date birthDate, String address, String email,
			String province, String city, String gender, String maritalStatus, String phoneNumber) {
		
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.email = email;
		this.province = province;
		this.city = city;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.phoneNumber = phoneNumber;
		this.workingStatus = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getEmail() {
		return email;
	}

	public String getProvince() {
		return province;
	}

	public String getCity() {
		return city;
	}

	public String getGender() {
		return gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public boolean isWorkingStatus() {
		return workingStatus;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setWorkingStatus(boolean workingStatus) {
		this.workingStatus = workingStatus;
	}

}
