import java.util.*;


public class Menu {

	public static void main(String[] args) {
		
		//Arraylist to hold all of the employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		//Scanner object used to scan user input through the standard input stream
		Scanner scan = new Scanner(System.in);
		
		//Create a flag variable to exit the while loop
		int flag = 1;
		
		while (flag == 1){
			int menuSelection = displayMenu();
			
			if (menuSelection == 4){
				//If quit is pressed, close the program
				flag = 0;
				System.exit(0);
			}
			if (menuSelection == 1){
				//First ask the type of employee
				System.out.println("Are you adding an Hourly, Salary or Contract employee?");
				System.out.println("Press 1 for Hourly, 2 for Salary, and 3 for Contract  employee");
				
				//Create a new employee object based on the type of employment
				switch (scan.nextInt()){
				case 1: HourlyEmployee hourlyEmployee = new HourlyEmployee();
						//What is the employee's name?
						System.out.println("First name?");
						hourlyEmployee.setFirstName(scan.next());
						System.out.println("Last name?");
						hourlyEmployee.setLastName(scan.next());
						//What is the employees company
						System.out.println("What is the employees company?");
						hourlyEmployee.setEmpCompany(scan.next());
						//Wages
						System.out.println("What is the wage?");
						hourlyEmployee.setWages(scan.nextDouble());
						//Hours
						System.out.println("How many hours were worked this week?");
						hourlyEmployee.setHours(scan.nextInt());
						//Add this employee to the array list
						employees.add(hourlyEmployee);
					break;
				case 2: SalaryEmployee salaryEmployee = new SalaryEmployee();
						//What is the employee's name?
						System.out.println("First name?");
						salaryEmployee.setFirstName(scan.next());
						System.out.println("Last name?");
						salaryEmployee.setLastName(scan.next());
						//What is the employees company
						System.out.println("What is the employees company?");
						salaryEmployee.setEmpCompany(scan.next());
						//Salary
						System.out.println("What is the salary?");
						salaryEmployee.setSalary(scan.nextDouble());
						//Add this employee to the array list
						employees.add(salaryEmployee);
					break;
				case 3: ContractEmployee contractEmployee = new ContractEmployee();
						//What is the employee's name?
						System.out.println("First name?");
						contractEmployee.setFirstName(scan.next());
						System.out.println("Last name?");
						contractEmployee.setLastName(scan.next());
						//What is the employees company
						System.out.println("What is the employees company?");
						contractEmployee.setEmpCompany(scan.next());
						//Salary
						System.out.println("What is the contract fee?");
						contractEmployee.setContractFee(scan.nextDouble());
						//Add this employee to the array list
						employees.add(contractEmployee);
					break;
				}//End switch	
			} //End if
			
			//If 2) list employees is selected on the menu
			if (menuSelection == 2 ){
				//Loop through all employees in the array list and print their toStrings.
				for (int i = 0; i < employees.size(); i++){
					System.out.println(employees.get(i));
				}
			}
			
			//If 3) list benefit status is selected on the menu
			if(menuSelection == 3){
				//Loop through all employees in the array list and print the result of their DetermineBenefits methods
				for(int i = 0; i < employees.size(); i++){
					System.out.println(employees.get(i).determineBenefits());
				}
			}
			
			
			
			
			
		} //End while
	}//End main
	
	public static int displayMenu(){
		//Create a scanner object to read which menu item the user would like to select
		Scanner scanMenu = new Scanner(System.in);
		
		System.out.println("Please select an option:");
		System.out.println("1) Add an Employee");
		System.out.println("2) List Employees");
		System.out.println("3) List Benefit Status");
		System.out.println("4) Quit");
		
		switch (scanMenu.nextInt()){
		case 1: return 1;
		case 2: return 2;
		case 3: return 3;
		case 4: return 4;}
		
		//Default flag
		return 0;
	}

}
