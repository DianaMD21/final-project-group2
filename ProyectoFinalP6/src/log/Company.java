package log;

import java.io.Serializable;

public class Company implements Serializable{
	private static final long serialVersionUID = -8340941357227668739L;
	private String rnc;
	private String name;
	private String area;
	private String address;
	private String province;
	private String city;
	private String phoneNumber;
	private String email;
	
	public Company( String name, String area, String address, String province, String city,
			String phoneNumber, String email,String rnc) {
		super();
		this.name = name;
		this.area = area;
		this.address = address;
		this.province = province;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.rnc=rnc;
	}
	
	public String getRnc() {
		return rnc;
	}
	
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
