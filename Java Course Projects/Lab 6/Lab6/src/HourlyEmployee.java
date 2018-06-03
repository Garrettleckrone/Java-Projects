
public class HourlyEmployee extends Employee {

	//Fields
	double wages;
	int hours;
	
	//Implementing determineBenefits method
	public String determineBenefits(){
		//
		//
		//The lab instruction says to only give benefits if the employee works less than 40 hours. 
		//I find this odd.
		//
		//
		if (hours <= 40){
			return (getFirstName() + " " + getLastName() + ": " +"This worker gets benefits!");
			
		}
		else return "No benefits";
	}
	//Implementing the getPay method
	public double getPay(){
		if(hours >= 40){
			return (wages*hours + (hours-40)*3);
		}
		else
			return wages*hours;
	}
	
	//Overridding the superclass toString method
	public String toString(){
		return (super.getFirstName() + " " 
				+ super.getLastName() + " from "
				+ super.getEmpCompany() + ". "
				+ "This worker's pay this week was "
				+ formatter.format(this.getPay()) + ".");	
	}
	//Mutator Methods
	public void setWages(double wage){
		wages = wage;
	}
	public void setHours(int hour){
		hours = hour;
	}
}
