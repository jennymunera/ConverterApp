package classes;

public class LengthConverter {

	public static double convertLength(double value, String fromUnit, String toUnit) {
        
		switch (fromUnit) {
        case "Metros":
            switch (toUnit) {
                case "Pulgadas":
                    return value * 39.3701;
                case "Pies":
                    return value * 3.28084;
                case "Kilómetros":
                    return value * 0.001;
                case "Millas":
                    return value * 0.000621371;
                case "Centímetros":
                    return value * 100;
                case "Milímetros":
                    return value * 1000;
            }
            break;
        case "Pulgadas":
            switch (toUnit) {
                case "Metros":
                    return value * 0.0254; // 1 pulgada = 0.0254 metros
                case "Pies":
                    return value / 12; // 1 pie = 12 pulgadas
                case "Kilómetros":
                    return value * 0.0000254; // 1 pulgada = 0.0000254 kilómetros
                case "Millas":
                    return value * 1.5783e-5; // 1 pulgada = 1.5783e-5 millas
                case "Centímetros":
                    return value * 2.54; // 1 pulgada = 2.54 centímetros
                case "Milímetros":
                    return value * 25.4; // 1 pulgada = 25.4 milímetros
            }
            break;
        case "Pies":
            switch (toUnit) {
                case "Metros":
                    return value * 0.3048; // 1 pie = 0.3048 metros
                case "Pulgadas":
                    return value * 12; // 1 pie = 12 pulgadas
                case "Kilómetros":
                    return value * 0.0003048; // 1 pie = 0.0003048 kilómetros
                case "Millas":
                    return value * 0.000189394; // 1 pie = 0.000189394 millas
                case "Centímetros":
                    return value * 30.48; // 1 pie = 30.48 centímetros
                case "Milímetros":
                    return value * 304.8; // 1 pie = 304.8 milímetros
            }
            break;
        
		}
		throw new IllegalArgumentException("Conversión no implementada: " + fromUnit + " a " + toUnit);
	}
}
	

