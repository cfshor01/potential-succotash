package assignment_4;

//imported packages for program functionality
import java.math.*;


//class implements the Comparable class
public class Temperature implements Comparable<Temperature> {
	private Double temperature;
	private String tempScale;

	//constructor to initialize instance variables
	public Temperature(Double temperature, String tempScale){
		this.temperature = temperature;
		this.tempScale = tempScale;
	}
	//second constructor to give value to instance variables
	public Temperature(){
		temperature = 0.0;
		tempScale = "C";
	}
	//method to set the temperature
	public void setTemperature(Double numOfDegrees, String Tscale) {
		temperature = numOfDegrees;
		tempScale = Tscale;
	}
	//getter method for getting temp value
	public Double getTemp() {
		return temperature;
	}
	//getter method for getting the unit
	public String getTscale() {
		return tempScale;
	}
	//compareTo method
	public int compareTo(Temperature inTemperature) {
		return this.temperature.compareTo(inTemperature.temperature);
	}
	//method which returns the class information in a string format
	public String toString() {
		temperature = Math.round(temperature * 10) / 10.0;
		return("Temperature: " + temperature + tempScale);
	}
	//method to convert from f to c
	public Double getCelsiusTemp(Double fTemp) {
		Double cTemp;
		
		cTemp = 5 * (fTemp - 32) / 9;
		
		return cTemp;
		
	}
	//method to convert from c to f
	public Double getFarenheitTemp(Double celsT) {
		Double fTemp;
		
		fTemp = ((9 * celsT) / 5) + 32;
		
		return fTemp;
	}

}
