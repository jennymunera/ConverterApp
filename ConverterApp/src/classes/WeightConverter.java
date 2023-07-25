package classes;

public class WeightConverter {
	 public static double convertKilogramsToPounds(double kilograms) {
	        return kilograms * 2.20462;
	    }

	    public static double convertPoundsToKilograms(double pounds) {
	        return pounds * 0.453592;
	    }

	    public static double convertKilogramsToOunces(double kilograms) {
	        return kilograms * 35.27396;
	    }

	    public static double convertOuncesToKilograms(double ounces) {
	        return ounces * 0.0283495;
	    }

	    public static double convertKilogramsToGrams(double kilograms) {
	        return kilograms * 1000;
	    }

	    public static double convertGramsToKilograms(double grams) {
	        return grams * 0.001;
	    }

	    public static double convertKilogramsToMilligrams(double kilograms) {
	        return kilograms * 1_000_000;
	    }

	    public static double convertMilligramsToKilograms(double milligrams) {
	        return milligrams * 0.000001;
	    }

	    public static double convertKilogramsToTons(double kilograms) {
	        return kilograms * 0.00110231;
	    }

	    public static double convertTonsToKilograms(double tons) {
	        return tons * 907.185;
	    }
}
