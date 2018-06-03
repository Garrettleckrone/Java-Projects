import java.text.DecimalFormat;


public abstract class Employee {

	//Fields
	private String employeeCompany;
	private String firstName;
	private String lastName;
	
	//Protected DecimalFormat object
	protected DecimalFormat formatter = new DecimalFormat("$##.##");
	
	//Methods
	public String toString(){
		return (firstName + " " 
				+ lastName  + " from "
				+ employeeCompany);	
	}
	
	//Abstract methods
	public abstract double getPay();
	public abstract String determineBenefits();
	
	//Accessor methods
	public String getEmpCompany(){
		return employeeCompany;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	//Mutator methods
	public void setEmpCompany(String company){
		employeeCompany = company;
	}
	public void setFirstName(String first){
		firstName = first;
	}
	public void setLastName(String last){
		lastName = last;
	}
}

