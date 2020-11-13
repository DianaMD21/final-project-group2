package log;

public class Main {

	public static void main(String[] args) {
		
		University uni1 = new University();
		Student stud1 = new Student("123", "Juan", "Alvares", "Villa Delia Sur", "Soltero", "8092587218", "10139130", "ISC","Sistemas");
		Teacher te1 = new Teacher("124", "Jorge", "Blanco", "Villa Olga", "Casado", "787887545", "CEX", 15000, (float)1.2, "Matematicas");
		Teacher te2 = new Teacher("125", "Alejandro", "Liz", "Villa Olga", "Casado", "787887599", "CIS", 18000,(float) 2.3, "Sistemas");
		uni1.addPerson(stud1);
		uni1.addPerson(te1);
		uni1.addPerson(te2);
		System.out.println(uni1.totalSalaryOfWorkers());

	}

}
