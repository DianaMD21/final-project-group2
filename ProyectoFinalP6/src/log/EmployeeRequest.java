package log;

public class EmployeeRequest {
	private String id;
	private Person applicant;
	private Boolean status;
	private float minSalary;
	
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

	public EmployeeRequest(String id, Person applicant, Boolean status, float minSalary) {
		super();
		this.id = id;
		this.applicant = applicant;
		this.status = status;
		this.minSalary = minSalary;
	}
}
