/*Garrett Leckrone
CS161 Project 1*/

import java.text.DecimalFormat;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AutoLoanInfo {
	//
	// Fields
	//
	// Payment Information Fields //Loan Term Fields
	private double totalLoanAmount = 0.0;
	private double interestRate;
	private double monthlyPayment = 0.0;
	private double totalPayment = 0.0;

	// Financing Information //Price with Options
	private double basePrice = 0.0;
	private final double autoTranny = 1800;
	private double downPayment = 0.0;
	private final double antiLockBrakes = 1200;
	private double salesTax = 0.0;
	private final double sunRoof = 800;
	private final double naviSystem = 1350;
	private final double audioPack = 1550;

	// Declares and instantiates JLabels that will be used for Payment
	// Information
	JLabel totalLoan = new JLabel("0.0");
	JLabel monthlyPayAmount = new JLabel("0.0");
	JLabel totalPayAmount = new JLabel("0.0");

	// Declare and instantiate radio buttons that will be used for the Loan Term
	JRadioButton radio24Months = new JRadioButton("24 Months");
	JRadioButton radio36Months = new JRadioButton("36 Months");
	JRadioButton radio48Months = new JRadioButton("48 Months");
	JRadioButton radio60Months = new JRadioButton("60 Months");

	// Create the text fields that will be used for Financing Information
	JTextField basePriceText = new JTextField("0.0");
	JTextField downPayText = new JTextField("0.0");
	JTextField salesTaxText = new JTextField("7.0");

	// Create the check boxes that will be used for Price with Options section
	JCheckBox autoTrannyBox = new JCheckBox("Auto Transmission: $1,800");
	JCheckBox antiLockBrakesBox = new JCheckBox("AntiLock Brake: $1,200");
	JCheckBox sunRoofBox = new JCheckBox("Sun Roof: $800");
	JCheckBox naviSystemBox = new JCheckBox("Navigation System: $1,350");
	JCheckBox audioPackageBox = new JCheckBox("Audio Package: $1,550");

	// Fields used for calculations
	double salesTaxAmount;

	//
	// End fields
	//

	// Constructor
	public AutoLoanInfo() {

	}

	// Setter for interest rate
	public void setInterestRate(double rate) {
		interestRate = rate;
	}

	// Getter for interest rate
	public double getInterestRate() {
		return interestRate;
	}

	// Resets the payment labels
	public void resetPaymentLabel() {
		totalLoan.setText("0.0");
		monthlyPayAmount.setText("0.0");
		totalPayAmount.setText("0.0");

	}

	// Resets the loan term radio buttons so that only the 24 months button is
	// selected.
	public void resetLoanTerm() {
		radio24Months.setSelected(true);
		radio36Months.setSelected(false);
		radio48Months.setSelected(false);
		radio60Months.setSelected(false);
	}

	// Resets the base price and down payment text fields
	public void resetBasePriceAndDownPayment() {
		basePriceText.setText("0.0");
		downPayText.setText("0.0");
		salesTaxText.setText("7.0");
	}

	// Resets the check boxes in the price with options region
	public void resetPriceWithOptions() {
		autoTrannyBox.setSelected(false);
		antiLockBrakesBox.setSelected(true);
		sunRoofBox.setSelected(false);
		naviSystemBox.setSelected(false);
		audioPackageBox.setSelected(false);
	}

	// Setter for the base price field
	public void setBasePrice(double price) {
		basePrice = price;
	}

	// Setter for the down payment field
	public void setDownPayment(double payment) {
		downPayment = payment;
	}

	// Setter for the sales tax field
	public void setSalesTax(double tax) {
		salesTax = tax;
	}

	// Calculates the amount of sales tax for the selected options
	public double calculateSalesTaxAmount() {
		salesTaxAmount = (basePrice - downPayment + totalOptionsCost())
				* (salesTax * .01);
		return salesTaxAmount;

	}

	// Calculates the total cost of all the additionally selected options
	public double totalOptionsCost() {
		double totalOptionsCost = 0;
		if (autoTrannyBox.isSelected()) {
			totalOptionsCost += autoTranny;
		}
		if (antiLockBrakesBox.isSelected()) {
			totalOptionsCost += antiLockBrakes;
		}
		if (sunRoofBox.isSelected()) {
			totalOptionsCost += sunRoof;
		}
		if (naviSystemBox.isSelected()) {
			totalOptionsCost += naviSystem;
		}
		if (audioPackageBox.isSelected()) {
			totalOptionsCost += audioPack;
		}
		return totalOptionsCost;
	}

	// Calculates the total loan amount
	public double totalLoanAmount() {
		double totalLoanAmount = 0;
		totalLoanAmount += Double.parseDouble(basePriceText.getText())
				- Double.parseDouble(downPayText.getText())
				+ totalOptionsCost() + salesTaxAmount;
		return totalLoanAmount;
	}

	// Calculates the rate
	public double calculateRate() {
		double rate = (this.getInterestRate() * .01) / 12;
		return rate;
	}

	// Calculates the total monthly payments
	public double totalMonthlyPayment() {
		monthlyPayment = (totalLoanAmount() * calculateRate())
				/ (1 - (Math
						.pow((1 / (1 + calculateRate())), loanTermInMonth())));
		return monthlyPayment;
	}

	// Calculates the total payment
	public double totalPayment() {
		return totalPayment = totalMonthlyPayment() * loanTermInMonth()
				+ Double.parseDouble(downPayText.getText());
	}

	// Determines how many months the loan will be for based on the selected
	// radio button
	public double loanTermInMonth() {
		double loanTermInMonth = 24;
		if (radio24Months.isSelected()) {
			loanTermInMonth = 24;
		}
		if (radio36Months.isSelected()) {
			loanTermInMonth = 36;
		}
		if (radio48Months.isSelected()) {
			loanTermInMonth = 48;
		}
		if (radio60Months.isSelected()) {
			loanTermInMonth = 60;
		}
		return loanTermInMonth;
	}

	// Sets the final payment information labels with the calculated values
	public void setPaymentInformation(double totalAmount, double monthlyAmount,
			double totalPayment) {
		DecimalFormat formatter = new DecimalFormat("0.00");
		totalLoan.setText(formatter.format(totalAmount));
		monthlyPayAmount.setText(formatter.format(monthlyPayment));
		totalPayAmount.setText(formatter.format(totalPayment));
	}
}
