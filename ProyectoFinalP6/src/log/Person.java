package log;

public abstract class Person {
	
	private String id;	
	private String name;
	private String last_name;
	private String address;
	private String marital_status;
	private String phone_number;
	
	public Person(String id, String name, String last_name, String address, String marital_status,
			String phone_number) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.marital_status = marital_status;
		this.phone_number = phone_number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}
