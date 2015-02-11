package org.usfirst.frc.team1899.robot.util;

public class Ramp {
	
	double targetValue;
	double currentValue;
	double velocity = 0;
	final double ratio;
	
	public Ramp(double ratio) {
		this.ratio = ratio;
	}
	
	public void set(double newValue) {
		targetValue = newValue; 
	}
	
	public void get() {
		velocity += (targetValue-currentValue)/ratio;
	}
}