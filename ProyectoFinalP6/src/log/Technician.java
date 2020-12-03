package log;

import java.util.Date;
import java.io.Serializable;

public class Technician extends Person implements Serializable{
	private static final long serialVersionUID = 5001357783348022449L;
	private String area;
	private String institution;
	private int workExperienceYears;

	public Technician(String id, String name, String lastName, Date birthDate, String address, String email, String province, String city,
			String gender, String maritalStatus, String phoneNumber, int workExperienceYears, String area, String institution) {
		
		super(id, name, lastName, birthDate, address, email, province, city, gender, maritalStatus, phoneNumber);
		this.workExperienceYears = workExperienceYears;
		this.area = area;
		this.institution = institution;
	}

	public int getWorkExperienceYears() {
		return workExperienceYears;
	}

	public void setWorkExperienceYears(int workExperienceYears) {
		this.workExperienceYears = workExperienceYears;
	}
	
	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
}
