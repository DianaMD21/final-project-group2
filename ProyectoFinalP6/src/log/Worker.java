package log;

import java.util.Date;
import java.util.List;

public class Worker extends Person {

	private List<String> skills;
	private int workExperience;
	
	public Worker(String id, String name, String lastName, Date birthDate, String address, String email,
			String province, String city, String gender, String maritalStatus, String phoneNumber, boolean travelAv,
			boolean moveAv, List<String> skills, int workExperience) {
		super(id, name, lastName, birthDate, address, email, province, city, gender, maritalStatus, phoneNumber,
				travelAv, moveAv);
		this.skills = skills;
		this.workExperience = workExperience;
	}

	public List<String> getSkills() {
		return skills;
	}

	public int getWorkExperience() {
		return workExperience;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}
}
