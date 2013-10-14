/** 
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @version 2013.10.06
 * Unit Testing Temperature class
 */

import org.junit.* ;

import static org.junit.Assert.* ;

public class TemperatureTest {

	public double PRECISION = 0.000001;
	
	@Test
	public void testGetValue() {
		Temperature boundaryTest = new Temperature(0.0,Temperature.Units.KELVIN);
		assertEquals("Temperature should equals 0.0 Kelvin", 0.0, boundaryTest.getValue(), PRECISION);
		
		Temperature negativeTest = new Temperature(-45.0, Temperature.Units.CELSIUS);
		assertEquals("Temperature should equal -45.0 Celsius", -45.0, negativeTest.getValue(), PRECISION);
		
		Temperature intTest = new Temperature(30, Temperature.Units.FAHRENHEIT);
		assertEquals("Temperature should equal 30.0 Celcius", 30.0, intTest.getValue(), PRECISION);
		
		Temperature precisionTest = new Temperature(60.1234567, Temperature.Units.CELSIUS);
		assertEquals("Temperature should equal 60.123456", 60.123456, precisionTest.getValue(), PRECISION);
	}
	
	@Test
	public void testGetUnits() {
		Temperature celsius = new Temperature(-10, Temperature.Units.CELSIUS);
		assertEquals("Units should be Celsius", Temperature.Units.CELSIUS, celsius.getUnits()); 
		
		Temperature fahrenheit = new Temperature(0, Temperature.Units.FAHRENHEIT); 
		assertEquals("Units should be Fahrenheit", Temperature.Units.FAHRENHEIT, fahrenheit.getUnits()); 
		
		Temperature kelvin = new Temperature(10, Temperature.Units.KELVIN);
		assertEquals("Units should be Kelvin", Temperature.Units.KELVIN, kelvin.getUnits()); 
	}
	
	@Test
	public void testChangeUnits() {
		Temperature kelvinToCelsius = new Temperature(0.0, Temperature.Units.KELVIN);
		kelvinToCelsius.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("Temperature should be -273.15", -273.15, kelvinToCelsius.getValue(), PRECISION);
		assertEquals("Temperature should be in Celsius", Temperature.Units.CELSIUS, kelvinToCelsius.getUnits()); 

		Temperature kelvinToFahrenheit = new Temperature(10.1234567, Temperature.Units.KELVIN);
		kelvinToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("Temperature should be -441.447777",-441.447777, kelvinToFahrenheit.getValue(), PRECISION);
		assertEquals("Temperature should be in Fahrenheit", Temperature.Units.FAHRENHEIT, kelvinToFahrenheit.getUnits());
		
		Temperature celsiusToKelvin = new Temperature(-25, Temperature.Units.CELSIUS);
		celsiusToKelvin.changeUnits(Temperature.Units.KELVIN);
		assertEquals("Temperature should be 248.15", 248.15, celsiusToKelvin.getValue(), PRECISION);
		assertEquals("Temperature should be in Kelvin", Temperature.Units.KELVIN, celsiusToKelvin.getUnits());

		Temperature celsiusToFahrenheit = new Temperature(40.5, Temperature.Units.CELSIUS);
		celsiusToFahrenheit.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals("Temperature should be 104.899999", 104.899999, celsiusToFahrenheit.getValue(), PRECISION);
		assertEquals("Temperature should be in Fahrenheit", Temperature.Units.FAHRENHEIT, celsiusToFahrenheit.getUnits());
		
		Temperature fahrenheitToKelvin = new Temperature(0.0, Temperature.Units.FAHRENHEIT);
		fahrenheitToKelvin.changeUnits(Temperature.Units.KELVIN);
		assertEquals("Temperature should be 255.372222", 255.372222, fahrenheitToKelvin.getValue(), PRECISION);
		assertEquals("Temperature should be in Kelvin", Temperature.Units.KELVIN, fahrenheitToKelvin.getUnits());
		
		Temperature fahrenheitToCelsius = new Temperature(104.899999, Temperature.Units.FAHRENHEIT);
		fahrenheitToCelsius.changeUnits(Temperature.Units.CELSIUS);
		assertEquals("Temperature should be 40.5", 40.5, fahrenheitToCelsius.getValue(), PRECISION);
		assertEquals("Temperature should be in Celsius", Temperature.Units.CELSIUS, fahrenheitToCelsius.getUnits());
		
	}
}
