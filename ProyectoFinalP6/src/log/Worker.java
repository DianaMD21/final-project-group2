package log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Worker extends Person {

	private List<String> skills;
	private int workExperience;
	
	public Worker(String id, String name, String lastName, Date birthDate, String address, String email,
			String province, String city, String gender, String maritalStatus, String phoneNumber, boolean travelAv,
			boolean moveAv, int workExperience) {
		super(id, name, lastName, birthDate, address, email, province, city, gender, maritalStatus, phoneNumber,
				travelAv, moveAv);
		this.skills = new ArrayList<>();
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
	
	public void addSkill(String skill) {
		this.skills.add(skill);
	}
	
	public boolean existSkill(String skill) {
		boolean found=false;
		for(int i=0;i<skills.size();i++) {
			if(skills.get(i).equalsIgnoreCase(skill)) {
				found=true;
				break;
			}
		}
		return found;
	}
}
