package log;

import java.util.Date;
import java.io.Serializable;

public class Student extends Person implements Serializable{
	private static final long serialVersionUID = -6017673707205368571L;
	private String university;
	private String career;

	public Student(String id, String name, String lastName, Date birthDate, String address, String email,
			String province, String city, String gender, String maritalStatus, String phoneNumber, String university, String career) {
		
		super(id, name, lastName, birthDate, address, email, province, city, gender, maritalStatus, phoneNumber);
		this.university = university;
		this.career = career;
	}
	

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

}
