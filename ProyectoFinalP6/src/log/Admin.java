package log;

public class Admin extends Worker {

	private String schedule;

	public Admin(String id, String name, String last_name, String address, String marital_status, String phone_number,
			String dep, float salary, float plusCharge, String schedule) {
		super(id, name, last_name, address, marital_status, phone_number, dep, salary, plusCharge);
		this.schedule = schedule;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}



}
