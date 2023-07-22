package appconverter;

import classes.CurrencyConverter;
import classes.LengthConverter;
import classes.TemperatureConverter;
import classes.WeightConverter;
import gui.ConverterWindow;

public class Application {
	
	CurrencyConverter currencyConverter;
	LengthConverter lengthConverter;
	TemperatureConverter temperatureConverter; 
	WeightConverter weightConverter;
	
	
	public Application() {
		
		showWindow();
		
		currencyConverter = new CurrencyConverter();
		lengthConverter = new LengthConverter();
		temperatureConverter = new TemperatureConverter();
		weightConverter = new WeightConverter();
	}


	private void showWindow() {
		ConverterWindow converterWindow = new ConverterWindow(); 
		converterWindow.setVisible(true);
		
	}
}
