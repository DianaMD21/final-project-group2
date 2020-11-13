package log;

import java.util.ArrayList;

public class University {

	private ArrayList<Person> persons;

	public University() {
		super();
		persons = new ArrayList<Person>();
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public void addPerson(Person person) {
		this.persons.add(person);
		return;
	}
	
	public double totalPay() {
		double sum = 0;
		for (Person person : persons) {
			if(person instanceof Worker) {
				sum +=((Worker) person).pay();
			}		
		}
		return sum;
	}

	public Person findByID(String id) {
		Person aux = null;
		Boolean found = false;
		int i = 0;
		while (!found && i < persons.size()) {
			if (persons.get(i).getId().equalsIgnoreCase(id)) {
				found = true;
				aux = persons.get(i);
			}
			i++;
		}
		return aux;
	}

	public float totalSalaryOfWorkers() {
		float total = 0;
		for (Person person : persons) {
			if (person instanceof Worker) {
				total += ((Worker) person).getSalary();
			}
		}
		return total;
	}
}
