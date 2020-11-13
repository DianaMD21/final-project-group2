package log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends Person {
	private List<String> languages;
	private String university;
	private String career;
	private int semesterAmount;

	public Student(String id, String name, String lastName, Date birthDate, String address, String email,
			String province, String city, String gender, String maritalStatus, String phoneNumber, boolean travelAv,
			boolean moveAv, String university, String career, int semesterAmount) {
		super(id, name, lastName, birthDate, address, email, province, city, gender, maritalStatus, phoneNumber,
				travelAv, moveAv);
		this.university = university;
		this.career = career;
		this.semesterAmount = semesterAmount;
		this.languages = new ArrayList<>();

	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
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

	public int getSemesterAmount() {
		return semesterAmount;
	}

	public void setSemesterAmount(int semesterAmount) {
		this.semesterAmount = semesterAmount;
	}
	
	public void addLanguage(String language) {
		this.languages.add(language);
	}
	
	public boolean existLanguage(String language) {
		boolean found=false;
		for(int i=0;i<languages.size();i++) {
			if(languages.get(i).equalsIgnoreCase(language)) {
				found=true;
				break;
			}
		}
		return found;
	}
}
