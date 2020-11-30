package log;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JobCenter jobcenter= JobCenter.getInstance();
		Company company1=new Company("", "", "", "Santiago", "", "", "", "");
		Person student=new Student(null, null, null, null, null, null, "Santiago", "", null, null, null, null, "Ingeniero Electrico");
		List<String> companyLanguages= new ArrayList<>();
		companyLanguages.add("Ingles");
		companyLanguages.add("Frances");
		companyLanguages.add("Espanol");
		CompanyRequest companyR=new CompanyRequest("000", company1, "Student", "Ingeniero Electrico", 1, 15000, false, companyLanguages, true, true, false);
		List<String> employeeLanguages= new ArrayList<>();
		employeeLanguages.add("Ingles");
		employeeLanguages.add("Espanol");
		EmployeeRequest employeeR=new EmployeeRequest("5555555", student, false, 20000, employeeLanguages, 0, true, false, true);
		
		jobcenter.addCompany(company1);
		jobcenter.addCompanyRequest(companyR);
		jobcenter.addEmployeeRquest(employeeR);
		jobcenter.addPerson(student);
		
		List<EmployeeRequest>list= jobcenter.match(companyR);
		
		System.out.print("Porciento: "+list.size());
	}

}
