	import java.text.*;


public class FutureValueApp {

	public static void main(String[] args) {
		int row = 0;
		String calculations[][] = new String[10][4];

		// display a welcome message
		System.out.println("Welcome to the Future Value Calculator");
		System.out.println();

		// perform 1 or more calculations
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			// get the input from the user
			System.out.println("DATA ENTRY");
			double monthlyInvestment = monthlyInvestment();
			double interestRate = interestRate();
			int years = getYear();


			// calculate the future value
			double monthlyInterestRate = monthlyInterest(interestRate);
			int months = years * 12;
			double futureValue = calculateFutureValue(
					monthlyInvestment, monthlyInterestRate, months);

			// get the currency and percent formatters
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMinimumFractionDigits(1);
			String results=printResult(monthlyInvestment,interestRate,years,futureValue,currency,percent);
			System.out.println();
			System.out.println("FORMATTED RESULTS");
			System.out.println(results);
            // format the values and store them in the array
			
            calculations[row][0] = currency.format(monthlyInvestment);
            calculations[row][1] = percent.format(interestRate / 100);
            calculations[row][2] = Integer.toString(years);
            calculations[row][3] = currency.format(futureValue);

            // increment the row counter
            row++;

			// see if the user wants to continue
			choice = Console.getString("Continue? (y/n): ");
			System.out.println();
		}

		// print the results
		System.out.println();
		System.out.println("Future Value Calculations");
		System.out.println();
		System.out.println("Inv/Mo.\tRate\tYears\tFuture Value");
		for (int i = 0; i < row; i++) {
			String message = "";
			for (int j = 0; j < 4; j++) {
				message += calculations[i][j] + "\t";
			}
			System.out.println(message);
		}
		System.out.println();
	}

	

	private static int getYear() {
		return Console.getInt("Provide Number of Year: ", 0, 100);
	}
	
	private static double interestRate() {
		return Console.getDouble("Provide Yearly Interest Rate: ", 0, 30);
	}
	
	private static double monthlyInvestment() {
		return Console.getDouble("Provide Monthly Investment: ", 0, 1000);
	}

	private static double monthlyInterest(double interestRate) {
		
		return (interestRate)/ 12 / 100;
	}

	private static String printResult(double monthlyInvestment, double interestRate, int years, double futureValue, NumberFormat currency, NumberFormat percent) {
		String results="Monthly investment:\t"  + currency.format(monthlyInvestment) + "\n"
				+ "Yearly interest rate:\t"
				+ percent.format(interestRate / 100) + "\n"
				+ "Number of years:\t"
				+ years + "\n"
				+ "Future value:\t\t"
				+ currency.format(futureValue) + "\n";
		return results;
		
	}

	public static double calculateFutureValue(double monthlyInvestment,
			double monthlyInterestRate, int months) {
		double futureValue = 0;
		for (int i = 1; i <= months; i++) {
			futureValue
			= (futureValue + monthlyInvestment)
			* (1 + monthlyInterestRate);
		}
		return futureValue;
	}
}