package appconverter;

import clases.CurrencyConverter;
import clases.LengthConverter;
import clases.TemperatureConverter;
import clases.WeightConverter;

public class Application {
	
	CurrencyConverter currencyConverter;
	LengthConverter lengthConverter;
	TemperatureConverter temperatureConverter;
	WeightConverter weightConverter; 
	
	public Application() {
		currencyConverter =new CurrencyConverter();
		lengthConverter = new LengthConverter();
		temperatureConverter =new TemperatureConverter();
		weightConverter = new WeightConverter(); 
	}
}
