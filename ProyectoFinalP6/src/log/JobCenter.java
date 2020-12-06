package log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JobCenter implements Serializable{
	private static final long serialVersionUID = 9046622424053111608L;
	private List<Company> myCompanies;
	private List<Person> myPersons;
	private List<EmployeeRequest> myEmployeeRequests;
	private List<CompanyRequest> myCompanyRequests;
	private static JobCenter jobcenter = null;
	
	private JobCenter() {
		super();
		this.myCompanies=new ArrayList<>();
		this.myPersons=new ArrayList<>();
		this.myEmployeeRequests=new ArrayList<>();
		this.myCompanyRequests=new ArrayList<>();
	}
	public static JobCenter getInstance() {
		if(jobcenter == null) {
			jobcenter = new JobCenter();
		}
		return jobcenter;
	}

	public static void setInstance(JobCenter jobcenter) {
		JobCenter.jobcenter = jobcenter;
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
		this.myCompanies.add(company);
	}
	public void modCompany(Company mod, Company aux) {
		int index = myCompanies.indexOf(mod);
		myCompanies.add(index, aux);
		myCompanies.remove(mod);	
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
	
	public List<CompanyRequest>getCompanyRequest(Company c){
		List<CompanyRequest> requests = new ArrayList<CompanyRequest>();
		for (CompanyRequest cr : myCompanyRequests) {
			if(cr.getCompany() == c && cr.isStatus()) {
				requests.add(cr);
			}	
		}
		return requests;
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

	public void modPerson(Person mod, Person aux) {
		int index = myPersons.indexOf(mod);
		myPersons.add(index, aux);
		myPersons.remove(mod);	
	}
	
	public int getSatisfiedEmployeeRequest() {
		int cant=0;
		for(EmployeeRequest er: myEmployeeRequests) {
			if(er.getStatus()==false)
				cant++;
		}
		return cant;
	}
	
	public List<EmployeeRequest> getAllStudentRequest(){
		List<EmployeeRequest> studentRequests=new ArrayList<>();
		for(EmployeeRequest e : myEmployeeRequests) {
			if(e.getApplicant() instanceof Student & e.getStatus())
				studentRequests.add(e);
		} 
		return studentRequests;
	}
	
	public int getAmountStudentRequestedByCompanies(){
		int amount=0;
		for(CompanyRequest e : myCompanyRequests) {
			if(e.getTypeOfEmployee().equalsIgnoreCase("Universitario") )
				amount++;
		} 
		return amount;
	}
	
	public int getAmountWorkerRequestedByCompanies(){
		int amount=0;
		for(CompanyRequest e : myCompanyRequests) {
			if(e.getTypeOfEmployee().equalsIgnoreCase("Técnico") )
				amount++;
		} 
		return amount;
	}
	
	public int getAmountTechnicianRequestedByCompanies(){
		int amount=0;
		for(CompanyRequest e : myCompanyRequests) {
			if(e.getTypeOfEmployee().equalsIgnoreCase("Obrero") )
				amount++;
		} 
		return amount;
	}
	
	public List<EmployeeRequest> getAllTechnicianRequest(){
		List<EmployeeRequest> technicianRequests=new ArrayList<>();
		for(EmployeeRequest e : myEmployeeRequests) {
			if(e.getApplicant() instanceof Technician && e.getStatus())
				technicianRequests.add(e);
		} 
		return technicianRequests;
	}
	
	public List<EmployeeRequest> getAllWorkerRequest(){
		List<EmployeeRequest> workerRequests=new ArrayList<>();
		for(EmployeeRequest e : myEmployeeRequests) {
			if(e.getApplicant() instanceof Worker && e.getStatus())
				workerRequests.add(e);
		} 
		return workerRequests;
	}
	
	public List<EmployeeRequest> match(CompanyRequest companyReq){
		List<EmployeeRequest> myEmployees=new ArrayList<>();
		List<EmployeeRequest> employeesThatApply=new ArrayList<>();
		if(companyReq.getTypeOfEmployee().equalsIgnoreCase("Student")) 
			myEmployees=this.getAllStudentRequest();
		else if(companyReq.getTypeOfEmployee().equalsIgnoreCase("Technician"))
			myEmployees=this.getAllTechnicianRequest();
		else
			myEmployees=this.getAllWorkerRequest();
		
		for(EmployeeRequest e: myEmployees) {
			if(getMatchPercentage(e,companyReq)>60) {
				employeesThatApply.add(e);
			}
		}
		
		return employeesThatApply;
		
	}
	public float getMatchPercentage(EmployeeRequest employeeR, CompanyRequest companyReq) {
		float percentage=0;
		float constant=companyReq.getLanguages().size()/13;
		if(employeeR.skillExists(companyReq.getSkillRequired())==true)
			percentage+=20;
		else
			return 0;
		if(employeeR.isMoveAv()==true && companyReq.isMoveAv()==true)
			percentage+=14;
		if(employeeR.getApplicant().getProvince().equalsIgnoreCase(companyReq.getCompany().getProvince()) 
				|| (employeeR.isMoveAv() &&employeeR.getApplicant().getProvince().equalsIgnoreCase(companyReq.getCompany().getProvince())==false))
			percentage+=14;
		if(employeeR.isDrivingLicense() && companyReq.isDrivingLicense())
			percentage+=13;
		if(employeeR.isTravelAv()&& companyReq.isTravelAv())
			percentage+=10;
		if(employeeR.getMinSalary()>=companyReq.getMinSalary())
			percentage+=16;
		percentage+=constant*amountEqualLanguages(companyReq.getLanguages(),employeeR.getLanguages());
		
		return percentage;
	}
	public float amountEqualLanguages(List<String> languagesComp, List<String> languagesPerson) {
		float amount=0;
		for(String comp: languagesComp) {
			for(String per: languagesPerson) {
				if (per.equalsIgnoreCase(comp))
					amount++;
			}
		}
		return amount;
	}
	public void eliminateAllActivePersonRequests(Person personToEliminate) {
		Boolean ok=true;
		int ind=0;
		EmployeeRequest aux = null;
		while(ok==true) {
			for(EmployeeRequest er: JobCenter.getInstance().getMyEmployeeRequests()) {
				if(er.getApplicant().getId().equalsIgnoreCase(personToEliminate.getId()) && er.getStatus()==true) {
					aux=er;
					ind++;
					break;
				}
			}
			if(ind==0)
				ok=false;
			else {
				JobCenter.getInstance().getMyEmployeeRequests().remove(aux);
				ind=0;
			}
		}
	}
	public void eliminateAllActiveCompanyRequests(Company companyToEliminate) {
		Boolean ok=true;
		int ind=0;
		CompanyRequest aux = null;
		while(ok==true) {
			for(CompanyRequest er: JobCenter.getInstance().getMyCompanyRequests()) {
				if(er.getCompany().getRnc().equalsIgnoreCase(companyToEliminate.getRnc()) && er.isStatus()==true) {
					aux=er;
					ind++;
					break;
				}
			}
			if(ind==0)
				ok=false;
			else {
				JobCenter.getInstance().getMyCompanyRequests().remove(aux);
				ind=0;
			}
		}
	}
	public List<CompanyRequest> getAllCompRequestByID(Company comp) {
		List<CompanyRequest> allCR=new ArrayList<>();
		for(CompanyRequest compR : myCompanyRequests) {
			if(compR.getCompany().getRnc().equalsIgnoreCase(comp.getRnc()) && compR.isStatus()==true) {
				allCR.add(compR);
			}
		}
		return allCR;
	}
	public List<EmployeeRequest> getAllEmployeeRequestByID(Person person) {
		List<EmployeeRequest> allER=new ArrayList<>();
		for(EmployeeRequest employR : myEmployeeRequests) {
			if(employR.getApplicant().getId().equalsIgnoreCase(person.getId()) && employR.getStatus()==true) {
				allER.add(employR);
			}
		}
		return allER;
	}

	public int amountCompaniesPerArea(String area) {
		int cant=0;
		for(Company comp: myCompanies) {
			if(comp.getArea().equalsIgnoreCase(area))
				cant++;
		}
		return cant;
	}
	
}
