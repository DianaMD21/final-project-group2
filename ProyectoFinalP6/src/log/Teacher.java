package log;

public class Teacher extends Worker {

	private String category;

	public Teacher(String id, String name, String last_name, String address, String marital_status, String phone_number,
			String dep, float salary, float plusCharge, String category) {
		super(id, name, last_name, address, marital_status, phone_number, dep, salary, plusCharge);
		this.category = category;
	}
	
	public float pay() {
		float totalSalary = super.pay();
		switch(category) {
			case "Instructor":
				totalSalary += salary*0.10;
				break;
			case "Asistant":
				totalSalary += salary*0.12;
				break;
			case "Auxiliar":
				totalSalary += salary*0.15;
				break;
			case "Principal":
				totalSalary += salary*0.20;
				break;
		}
		return totalSalary;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
