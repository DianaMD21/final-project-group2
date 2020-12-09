package log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class Worker extends Person implements Serializable{
	private static final long serialVersionUID = -6278621719200443443L;
	private List<String> skills;
	private int workExperience;
	
	public Worker(String id, String name, String lastName, Date birthDate, String address, String email, String province, String city, String gender, String maritalStatus, String phoneNumber, int workExperience, ArrayList<String>skills) {
		super(id, name, lastName, birthDate, address, email, province, city, gender, maritalStatus, phoneNumber);
		
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
