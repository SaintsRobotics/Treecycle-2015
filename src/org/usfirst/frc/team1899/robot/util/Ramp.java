package org.usfirst.frc.team1899.robot.util;

public class Ramp {
    
    double oldValue = 0;
    
    public double rampValues(double targetValue) {
    	double newValue = oldValue;
    	if(Math.abs(oldValue - targetValue) > 0.5)
    		newValue += oldValue < targetValue ? 0.5 : -0.5;
    	else
    		newValue = targetValue;
    	oldValue = newValue;
    	return newValue;
    }
    
}