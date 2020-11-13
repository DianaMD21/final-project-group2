package log;

public class Student extends Person {

	private String unID;
	private String faculty;
	private String career;
	private int[] grades;

	public Student(String id, String name, String last_name, String address, String marital_status, String phone_number,String unID,
			String career, String faculty) {
		super(id, name, last_name, address, marital_status, phone_number);
		this.career = career;
		this.unID = unID;
		this.faculty = faculty;
		this.grades = new int[10];
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	public String getUnID() {
		return unID;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setUnID(String unID) {
		this.unID = unID;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
