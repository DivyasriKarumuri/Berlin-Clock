package com.ubs.opsit.interviews;

public class BerlinClock implements TimeConverter {
	 public String convertTime(String aTime){
		 
		boolean validTime = BerlinClockUtil.validate24HrsClockTime(aTime);
		if(!validTime)
			throw new IllegalArgumentException("Invalid time");
		
		String[] aTimes = aTime.split(":", 3);
		StringBuilder clockOp = new StringBuilder();
		int hours = Integer.parseInt(aTimes[0]);
		int minutes = Integer.parseInt(aTimes[1]);
		int seconds = Integer.parseInt(aTimes[2]);

		clockOp.append(getSecondsRow(seconds));
		clockOp.append("\n");
		clockOp.append(getFirstRow(hours));
		clockOp.append("\n");	
		clockOp.append(getSecondRow(hours));
		clockOp.append("\n");		
		clockOp.append(getThirdRow(minutes));
		clockOp.append("\n");	
		clockOp.append(getFourthRow(minutes));
		
		return clockOp.toString();
	}
	
	public StringBuilder getSecondsRow(int sec){
		StringBuilder calOp = new StringBuilder();
		if(sec%2 ==0) calOp.append("Y"); 
		else  	calOp.append("O");
		return calOp;
	}
	
	public StringBuilder getFirstRow(int hours){
		StringBuilder calOp = new StringBuilder();
		int num5MulHrs = hours/5;
		for(int i = 0; i < 4; i++){
			if(num5MulHrs-i > 0)
				calOp.append("R");
			else
				calOp.append("O");
		}
		return calOp;
	}
	
	public StringBuilder getSecondRow(int hours){
		StringBuilder calOp = new StringBuilder();
		int num1MulHrs = 0;
		if(hours > 20)
			num1MulHrs = hours - 20;
		else if(hours > 0) 
			num1MulHrs = hours % 5;
		else if(hours == 0)
			num1MulHrs = 0;
		
		for(int i = 0; i < 4; i++){
			if(num1MulHrs-i > 0)
				calOp.append("R");
			else
				calOp.append("O");
		}		
		return calOp;
	}
	
	public StringBuilder getThirdRow(int min){
		StringBuilder calOp = new StringBuilder();
		int num5MulMin = min/5;
		for(int i = 0; i < 11; i++){
			if(num5MulMin-i > 0){
				if((i + 1) % 3 == 0) 
					calOp.append("R");
				else
					calOp.append("Y");
			}
			else
				calOp.append("O");
		}
		return calOp;
	}
	
	public StringBuilder getFourthRow(int min){
		StringBuilder calOp = new StringBuilder();
		int num1MulMin = 0;
		if(min > 55)
			num1MulMin = min - 55;
		else if(min > 0) 
			num1MulMin = min % 5;
		else if(min == 0)
			num1MulMin = 0;
		
		for(int i = 0; i < 4; i++){
			if(num1MulMin-i > 0)
				calOp.append("Y");
			else
				calOp.append("O");
		}		
		return calOp;
	}	
}
