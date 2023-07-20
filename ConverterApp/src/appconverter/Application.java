package appconverter;

import classes.CurrencyConverter;
import classes.LengthConverter;
import classes.TemperatureConverter;
import classes.WeightConverter;

public class Application {
	
	CurrencyConverter currencyConverter;
	LengthConverter lengthConverter;
	TemperatureConverter temperatureConverter; 
	WeightConverter weightConverter;
	
	
	public Application() {
		currencyConverter = new CurrencyConverter();
		lengthConverter = new LengthConverter();
		temperatureConverter = new TemperatureConverter();
		weightConverter = new WeightConverter();
	}
}
