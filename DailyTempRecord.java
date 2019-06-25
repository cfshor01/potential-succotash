package assignment_4;

//imported packages for program functionality
import java.io.*;
import java.util.Scanner;

public class DailyTempRecord {

	public static void main(String args[]) throws IOException {
		String scaleTemp;
		char charTemp;
		Double dTemp;
		char cTemp;
		int count = 1;
		Temperature[] tempObj = new Temperature[100]; 
		
				
		Double temperature;
		String TempScale;
		//new file which contains the information for the temperatures
		File file = new File("C:\\Users\\crist\\eclipse-workspace\\assignments\\src\\assignment_4\\TempRec.txt");
		//scanner object which reads upon the file
		Scanner scan = new Scanner(file);
		//iterates through the file while there is information
		while(scan.hasNext()) {
			
			dTemp = scan.nextDouble(); //assigns to temperature value
			scaleTemp = scan.nextLine(); //assigns to scale
			charTemp = scaleTemp.charAt(0); //assigns char value from string
			
			//used for class parameters
			temperature = dTemp;
			TempScale = scaleTemp;
			
			//assigns each temperature object to a temperature object
			//parameters set the temperature and scale
			tempObj[count] = new Temperature(temperature, TempScale);
			//increases the count
			count++;
		}
		//Daily_Temperatures object which uses tempObj array and count
		Daily_Temperatures dt= new Daily_Temperatures(tempObj, count);
		System.out.println("Daily Temps:");
		//sets amount equal to value from getTempList method
		//prints out list of temperatures
		dt.getTempList();
		//prints out report of sequence of temperatures
		System.out.println("Hottest Day in Celsius: " + dt.htemp("C"));
		System.out.println("Hottest Day in Farenheit: " + dt.htemp("F"));
		System.out.println("Coldest Day in Celsius: " + dt.ctemp("C"));
		System.out.println("Coldest Day in Farenheit: " + dt.ctemp("F"));
		System.out.println(dt.avgTemp("C"));
		System.out.println(dt.avgTemp("F"));
		System.out.println("Days below freezing: " + dt.daysBelowFreezing("C"));
	}

}
