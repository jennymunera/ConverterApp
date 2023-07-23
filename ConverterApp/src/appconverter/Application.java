package appconverter;

import classes.CurrencyApi;
import classes.LengthConverter;
import classes.TemperatureConverter;
import classes.WeightConverter;
import gui.ConverterWindow;

public class Application {
	
	CurrencyApi currencyApi;
	LengthConverter lengthConverter;
	TemperatureConverter temperatureConverter; 
	WeightConverter weightConverter;
	
	
	public Application() {
		
		currencyApi = new CurrencyApi();
		lengthConverter = new LengthConverter();
		temperatureConverter = new TemperatureConverter();
		weightConverter = new WeightConverter();
		
		showWindow();
		
		
	}


	private void showWindow() {
		ConverterWindow converterWindow = new ConverterWindow(currencyApi); 
		converterWindow.setVisible(true);
		converterWindow.setResizable(false);
		converterWindow.setLocationRelativeTo(null); // centrar la aplicacion
		
	}
}
