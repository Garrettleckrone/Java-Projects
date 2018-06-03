
public class SalaryEmployee extends Employee{

	//Fields
	double salary;
	
	//getPay method
	public double getPay(){
		return salary;
	}
	//determine benefits method
	public String determineBenefits(){
		return getFirstName() + " " + getLastName() + ": " +"This employee has a standard company health insurance policy";
	}
	//Overridding the toString method of the superclass
	public String toString(){
		return (super.getFirstName() + " " 
				+ super.getLastName() + " from "
				+ super.getEmpCompany() + ". "
				+ "This worker's salary is "
				+ formatter.format(this.getPay()) + ".");	
	}
	public void setSalary(double salary){
		this.salary = salary;
	}
}
