package log;

public class CompanyRequest {
	private String id;
	private Company company;
	private String typeOfEmployee;
	private String skillRequired;
	private int quantity;
	private float minSalary;
	private boolean status;
	
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
	
	public void setMinSalary(float minSalary) {
		this.minSalary = minSalary;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public CompanyRequest(String id, Company company, String typeOfEmployee, String skillRequired, int quantity,
			float minSalary, boolean status) {
		super();
		this.id = id;
		this.company = company;
		this.typeOfEmployee = typeOfEmployee;
		this.skillRequired = skillRequired;
		this.quantity = quantity;
		this.minSalary = minSalary;
		this.status = status;
	}
}
