package log;

import java.util.List;

public class EmployeeRequest {
	private String id;
	private Person applicant;
	private Boolean status;
	private float minSalary;
	private List<String> languages;
	private int workingHours;
	private boolean travelAv;
	private boolean moveAv;
	private boolean drivingLicense;
	public static int cod = 0;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Person getApplicant() {
		return applicant;
	}
	
	public void setApplicant(Person applicant) {
		this.applicant = applicant;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public float getMinSalary() {
		return minSalary;
	}
	
	public void setMinSalary(float minSalary) {
		this.minSalary = minSalary;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public boolean isMoveAv() {
		return moveAv;
	}

	public void setMoveAv(boolean moveAv) {
		this.moveAv = moveAv;
	}

	public boolean isTravelAv() {
		return travelAv;
	}

	public void setTravelAv(boolean travelAv) {
		this.travelAv = travelAv;
	}

	public boolean isDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(boolean drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public EmployeeRequest(String id, Person applicant, Boolean status, float minSalary, List<String> languages,
			int workingHours, boolean travelAv, boolean moveAv, boolean drivingLicense) {
		super();
		this.id = id;
		this.applicant = applicant;
		this.status = status;
		this.minSalary = minSalary;
		this.languages = languages;
		this.workingHours = workingHours;
		this.travelAv = travelAv;
		this.moveAv = moveAv;
		this.drivingLicense = drivingLicense;
	}

	public boolean skillExists(String skillRequired) {
		if(applicant instanceof Student) {
			Student student=(Student)applicant;
			if(student.getCareer().equalsIgnoreCase(skillRequired))
				return true;
		}
		else if(applicant instanceof Technician) {
			Technician technician=(Technician)applicant;
			if(technician.getArea().equalsIgnoreCase(skillRequired))
				return true;
		}
		else {
			Worker worker=(Worker)applicant;
			for(String s: worker.getSkills()) {
				if(s.equalsIgnoreCase(skillRequired))
					return true;
			}
		}
		return false;
	}

}
