package classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONObject;


public class CurrencyApi {

	private static JSONObject exchangeRates;
	private Map<String, String> currencyInfo; // Información sobre las monedas (código -> nombre completo)


	public CurrencyApi() {
		exchangeRates = getExchangeRatesFromAPI();
		currencyInfo = loadCurrencyInfoFromProperties(); // Cargamos la información desde el archivo CSV
	}

	

	private JSONObject getExchangeRatesFromAPI() {
		HttpURLConnection conn = null;

		try {
			// Lee la API key desde el archivo de configuración
			String apiKey = readApiKeyFromConfig();

			// Construir la URL de la API
			String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

			// Realizar la solicitud HTTP
			URL url = new URL(apiUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			// Leer la respuesta de la API
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Procesar la respuesta de la API
			System.out.println(response.toString());

			return new JSONObject(response.toString()).getJSONObject("conversion_rates");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		return null;

	}

	// metodo para obtner la apiKey
	private static String readApiKeyFromConfig() throws IOException {
		InputStream input = CurrencyApi.class.getClassLoader().getResourceAsStream("config/config.properties");
		if (input == null) {
			throw new FileNotFoundException("config.properties file not found");
		}

		Properties prop = new Properties();
		prop.load(input);
		return prop.getProperty("apikey");
	}
    
    private Map<String, String> loadCurrencyInfoFromProperties() {
    	 Map<String, String> currencyInfo = new HashMap<>();

    	 Properties properties = new Properties();
         try (FileInputStream fis = new FileInputStream("/Users/jennymunera/Documents/GitHub/ConverterApp/ConverterApp/src/config/currency_info.properties")) {
             properties.load(fis);
         } catch (IOException e) {
             e.printStackTrace();
         }

         for (String currencyCode : properties.stringPropertyNames()) {
             String currencyName = properties.getProperty(currencyCode);
             currencyInfo.put(currencyCode, currencyName);
         }

         return currencyInfo;
     }
    
 // Método para obtener los nombres de las monedas desde las tasas de cambio
    public String[] getCurrencyNames() {
    	 if (exchangeRates != null && currencyInfo != null) {
             Iterator<String> keys = exchangeRates.keys();
             List<String> currencyNames = new ArrayList<>();
             while (keys.hasNext()) {
                 String currencyCode = keys.next();
                 String currencyName = currencyInfo.get(currencyCode); // Obtenemos el nombre completo desde el mapa
                 if (currencyName != null) {
                     currencyNames.add(currencyCode + " - " + currencyName);
                 }
             }
             return currencyNames.toArray(new String[0]);
         } else {
             return new String[0];
         }
     }
        
    

    // Método para obtener el valor de cambio de una moneda específica
    public Double getExchangeRate(String currency) {
        if (exchangeRates != null && exchangeRates.has(currency)) {
            return exchangeRates.getDouble(currency);
        } else {
            return null;
        }
    }

	
}
