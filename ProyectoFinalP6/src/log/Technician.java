package log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Technician extends Person{
	private List<String> areas;
	private int workExperienceYears;

	public Technician(String id, String name, String lastName, Date birthDate, String address, String email,
			String province, String city, String gender, String maritalStatus, String phoneNumber, boolean travelAv,
			boolean moveAv, int workExperienceYears) {
		super(id, name, lastName, birthDate, address, email, province, city, gender, maritalStatus, phoneNumber, travelAv,
				moveAv);
		this.workExperienceYears=workExperienceYears;
		this.areas=new ArrayList<>();
	}

	public List<String> getAreas() {
		return areas;
	}

	public void setAreas(List<String> areas) {
		this.areas = areas;
	}

	public int getWorkExperienceYears() {
		return workExperienceYears;
	}

	public void setWorkExperienceYears(int workExperienceYears) {
		this.workExperienceYears = workExperienceYears;
	}
	
	public void addArea(String area) {
		this.areas.add(area);
	}
	
	public boolean existArea(String area) {
		boolean found=false;
		for(int i=0;i<areas.size();i++) {
			if(areas.get(i).equalsIgnoreCase(area)) {
				found=true;
				break;
			}
		}
		return found;
	}

}
