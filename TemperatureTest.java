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
}
