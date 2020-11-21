package log;

import java.util.ArrayList;
import java.util.List;

public class JobCenter {
	private List<Company> myCompanies;
	private List<Person> myPersons;
	private List<EmployeeRequest> myEmployeeRequests;
	private List<CompanyRequest> myCompanyRequests;
	
	public JobCenter() {
		super();
		this.myCompanies=new ArrayList<>();
		this.myPersons=new ArrayList<>();
		this.myEmployeeRequests=new ArrayList<>();
		this.myCompanyRequests=new ArrayList<>();
	}

	public List<Company> getMyCompanies() {
		return myCompanies;
	}

	public void setMyCompanies(List<Company> myCompanies) {
		this.myCompanies = myCompanies;
	}

	public List<Person> getMyPersons() {
		return myPersons;
	}

	public void setMyPersons(List<Person> myPersons) {
		this.myPersons = myPersons;
	}

	public List<EmployeeRequest> getMyEmployeeRequests() {
		return myEmployeeRequests;
	}

	public void setMyEmployeeRequests(List<EmployeeRequest> myEmployeeRequests) {
		this.myEmployeeRequests = myEmployeeRequests;
	}

	public List<CompanyRequest> getMyCompanyRequests() {
		return myCompanyRequests;
	}

	public void setMyCompanyRequests(List<CompanyRequest> myCompanyRequests) {
		this.myCompanyRequests = myCompanyRequests;
	}
	
	public void addCompany(Company company) {
		company.setRnc(String.valueOf(myCompanies.size()));
		this.myCompanies.add(company);
	}
	
	public void addPerson(Person person) {
		this.myPersons.add(person);
	}
	
	public void addEmployeeRquest(EmployeeRequest employeeRequest) {
		this.myEmployeeRequests.add(employeeRequest);
	}
	
	public void addCompanyRequest(CompanyRequest companyRequest) {
		this.myCompanyRequests.add(companyRequest);
	}
	
	public Company findCompanyById(String id) {
		for(Company c : myCompanies) {
			if(c.getRnc().equalsIgnoreCase(id))
				return c;
		}
		return null;
	}
	
	public Person findPersonById(String id) {
		for(Person p : myPersons) {
			if(p.getId().equalsIgnoreCase(id))
				return p;
		}
		return null;
	}
	
	public CompanyRequest findCompanyRequestById(String id) {
		for(CompanyRequest c : myCompanyRequests) {
			if(c.getId().equalsIgnoreCase(id))
				return c;
		}
		return null;
	}
	
	public EmployeeRequest findEmployeeRequestById(String id) {
		for(EmployeeRequest e : myEmployeeRequests) {
			if(e.getId().equalsIgnoreCase(id))
				return e;
		}
		return null;
	}
	
	public List<Person> getAllStudents(){
		List<Person> allStudents=new ArrayList<>();
		for(Person p : myPersons) {
			if(p instanceof Student)
				allStudents.add((Student) p);
		} 
		return allStudents;
	}
	
	public List<Person> getAllTechnicians(){
		List<Person> allTechnicians=new ArrayList<>();
		for(Person p : myPersons) {
			if(p instanceof Technician)
				allTechnicians.add((Technician) p);
		} 
		return allTechnicians;
	}
	
	public List<Person> getAllWorkers(){
		List<Person> allWorkers=new ArrayList<>();
		for(Person p : myPersons) {
			if(p instanceof Worker)
				allWorkers.add((Worker) p);
		} 
		return allWorkers;
	}

}
