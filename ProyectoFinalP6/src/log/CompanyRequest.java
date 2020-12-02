package log;

import java.util.List;

public class CompanyRequest {
	private String id;
	private Company company;
	private String typeOfEmployee;
	private String skillRequired;
	private int quantity;
	private float minSalary;
	private boolean status;
	private List<String> languages;
	private boolean travelAv;
	private boolean moveAv;
	private boolean drivingLicense;
	private int workingHours;
	public static int cod = 0;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String getTypeOfEmployee() {
		return typeOfEmployee;
	}
	
	public void setTypeOfEmployee(String typeOfEmployee) {
		this.typeOfEmployee = typeOfEmployee;
	}
	
	public String getSkillRequired() {
		return skillRequired;
	}
	
	public void setSkillRequired(String skillRequired) {
		this.skillRequired = skillRequired;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getMinSalary() {
		return minSalary;
	}
	
	public void setMaxSalary(float minSalary) {
		this.minSalary = minSalary;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public boolean isTravelAv() {
		return travelAv;
	}

	public void setTravelAv(boolean travelAv) {
		this.travelAv = travelAv;
	}

	public boolean isMoveAv() {
		return moveAv;
	}

	public void setMoveAv(boolean moveAv) {
		this.moveAv = moveAv;
	}

	public boolean isDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(boolean drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public CompanyRequest(String id, Company company, String typeOfEmployee, String skillRequired, int quantity,
			float minSalary, boolean status, List<String> languages, boolean travelAv, boolean moveAv,
			boolean drivingLicense, int workingHours) {
		super();
		this.id = id;
		this.company = company;
		this.typeOfEmployee = typeOfEmployee;
		this.skillRequired = skillRequired;
		this.quantity = quantity;
		this.minSalary = minSalary;
		this.status = status;
		this.languages = languages;
		this.travelAv = travelAv;
		this.moveAv = moveAv;
		this.drivingLicense = drivingLicense;
		this.workingHours = workingHours;
	}
}
