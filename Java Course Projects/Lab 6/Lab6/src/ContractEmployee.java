
public class ContractEmployee extends HourlyEmployee {

	//Fields
	double contractFee;
	
	//Implementing the getPay method
		public double getPay(){
			return hours*wages+contractFee;
		}
	//Implementing determineBenefits method
		public String determineBenefits(){
			return getFirstName() + " " + getLastName() + ": " +"Contract workers get no benefits";
		}
		
	//Mutator method
		public void setContractFee(double fee){
			contractFee = fee;
		}
}
