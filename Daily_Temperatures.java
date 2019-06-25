package assignment_4;

//class extends Temperature class in order to access its methods
public class Daily_Temperatures extends Temperature {
	//creates a new array of Temperature objects
	private Temperature[] tempObj = new Temperature[365];
	private int daysRecorded = 0;
	
	//constructor which initializes the instance variables
	public Daily_Temperatures(Temperature[] tempObj, int daysRecorded){
		this.daysRecorded = daysRecorded;
		this.tempObj = tempObj;
	}
	//method for determining days below freezing
	public int daysBelowFreezing(String tempScale) {
		int days = 0;
		//variables used for determining what the scale is
		String cTest;
		char cTester;

		if(tempScale == "C") {
			for(int i = 1; i < 100; i++) {
				if(tempObj[i] != null) { //loop runs while object exists
					cTest = tempObj[i].getTscale();
					cTester = cTest.charAt(0); //sets the char variable 
					if(cTester == 'F') { //sets farenheit temps to Celsius
						tempObj[i].setTemperature(tempObj[i].getCelsiusTemp(tempObj[i].getTemp()), "C");
					}
				}
			}
			//goes through and sees which days are freezing or below
			for(int k = 0; k < 100; k++) {
				if(tempObj[k]!=null) {
					if(tempObj[k].getTemp() <= 0) {
						days++;
					}
				}
			}
		}
		return days;
	}
	//method to determine hottest temperature
	public Temperature htemp(String tempScale) {
		//local variables to determine scale
		
		String cTest;
		char cTester;
		
		String fTest;
		char fTester;
		//sets new Temperature object for the hottest day
		Temperature hottestDay = new Temperature();
		//goes through and changes all temps to Celsius
		if(tempScale == "C") {
			for(int i = 1; i < 100; i++) {
				if(tempObj[i] != null) {
					cTest = tempObj[i].getTscale();
					cTester = cTest.charAt(1);
					if(cTester == 'F') {
						tempObj[i].setTemperature(tempObj[i].getCelsiusTemp(tempObj[i].getTemp()), "C");
					}
				}
			}
		//sets hottest day object to the first temperature object
			hottestDay = tempObj[1];
		//sets hottest day equal to hottest temperature
			for(int i = 2; i < 100; i++) {
				if(tempObj[i] != null) {
					if(tempObj[i].getTemp() > hottestDay.getTemp()) {
						hottestDay = tempObj[i];
					}
				}
			}
		}
		//same as above except for changing temps to farenheit
		else {
			for(int i = 1; i < 100; i++) {
				if(tempObj[i] != null) {
					fTest = tempObj[i].getTscale();
					fTester = fTest.charAt(0);
					if(fTester == 'C') {
						tempObj[i].setTemperature(tempObj[i].getFarenheitTemp(tempObj[i].getTemp()), "F");
					}
				}
			}
			
			hottestDay = tempObj[1];
			
			for(int i = 2; i < 100; i++) {
				if(tempObj[i] != null) {
					if(tempObj[i].getTemp() > hottestDay.getTemp()) {
						hottestDay = tempObj[i];
					}
				}
			}
		}
		return hottestDay;
	}
	//method to determine coldest temperature
	public Temperature ctemp(String tempScale) {
		//variables for determining scale
		String cTest;
		char cTester;
		
		String fTest;
		char fTester;
		//new temperature object to represent coldest day
		Temperature coldestDay = new Temperature();
		//sets all temps to celsius
		if(tempScale == "C") {
			for(int i = 1; i < 100; i++) {
				if(tempObj[i] != null) {
					cTest = tempObj[i].getTscale();
					cTester = cTest.charAt(0);
					if(cTester == 'F') {
						tempObj[i].setTemperature(tempObj[i].getCelsiusTemp(tempObj[i].getTemp()), "C");
					}
				}
			}
			//sets coldestday to first temperature object
			coldestDay = tempObj[1];
			//sets coldsestday to the coldest temperature
			for(int i = 2; i < 100; i++) {
				if(tempObj[i] != null) {
					if(tempObj[i].getTemp() < coldestDay.getTemp()) {
						coldestDay = tempObj[i];
					}
				}
			}
			
		}
		//same as above except for farenheit
		else {
			for(int i = 1; i < 100; i++) {
				if(tempObj[i] != null) {
					fTest = tempObj[i].getTscale();
					fTester = fTest.charAt(0);
					if(fTester == 'C') {
						tempObj[i].setTemperature(tempObj[i].getFarenheitTemp(tempObj[i].getTemp()), "F");
					}
				}
			}
			
			coldestDay = tempObj[1];
			
			for(int i = 2; i < 100; i++) {
				if(tempObj[i] != null) {
					if(tempObj[i].getTemp() < coldestDay.getTemp()) {
						coldestDay = tempObj[i];
					}
				}
			}
		}
		return coldestDay;
	}
	//method to determine average temperature
	public Double avgTemp(String tempScale) {
		
		//local variables created for method functionality
		Double average = null;
		Double total = 0.0;
		int count = 0;
		//used for determining scale
		String cTest;
		char cTester;
		
		String fTest;
		char fTester;
		//sets all temps to celsius
		if(tempScale == "C") {
			for(int i = 1; i < 100; i++) {
				if(tempObj[i] != null) {
					cTest = tempObj[i].getTscale();
					cTester = cTest.charAt(0);
					if(cTester == 'F') {
						tempObj[i].setTemperature(tempObj[i].getCelsiusTemp(tempObj[i].getTemp()), "C");
					}
				}
			}
			//gets sum of temps along with count
			for(int i = 1; i < 100; i++) {
				if(tempObj[i]!=null) {
					total = tempObj[i].getTemp() + total;
					count++;
				}
			}
			average = total / count; // determines the average temperature
			System.out.print("Celsius Average: ");
			
		}
		//same as above except for in farenheit
		else {
			for(int i = 1; i < 100; i++) {
				if(tempObj[i] != null) {
					fTest = tempObj[i].getTscale();
					fTester = fTest.charAt(0);
					if(fTester == 'C') {
						tempObj[i].setTemperature(tempObj[i].getFarenheitTemp(tempObj[i].getTemp()), "F");
					}
				}
			}
			
			for(int i = 1; i < 100; i++) {
				if(tempObj[i]!=null) {
					total = tempObj[i].getTemp() + total;
					count++;
				}
			}

			average = total / count;
			System.out.print("Farenheit Average: ");
		}
		
		return average = Math.round(average*10)/10.0;
	}
	//method for getting instance variables of array of temperature objects
	public void getTempList() {
		int count = 1;
		for(int i = 1; i < tempObj.length; i++) {
			if(tempObj[i]!=null) {
				System.out.println(count +"." +tempObj[i]);
				count++;
			}
		}
		

	}

}
