package log;

public abstract class Worker extends Person {

	private String dep;
	protected float salary;
	private float plusCharge;

	public Worker(String id, String name, String last_name, String address, String marital_status, String phone_number,
			String dep, float salary, float plusCharge) {
		super(id, name, last_name, address, marital_status, phone_number);
		this.dep = dep;
		this.salary = salary;
		this.plusCharge = plusCharge;
	}
	
	public float pay() {
		return salary + plusCharge;
	}
	
	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public float getPlusCharge() {
		return plusCharge;
	}

	public void setPlusCharge(float plusCharge) {
		this.plusCharge = plusCharge;
	}


}
