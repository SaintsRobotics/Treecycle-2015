package org.usfirst.frc.team1899.robot.util;

public class Ramp {
    
    double oldValue = 0;
    double amount;
    
    public Ramp(double amount) {
        this.amount = Math.abs(amount);
    }
    
    public double rampValues(double targetValue) {
    	double newValue = oldValue;
    	if(Math.abs(oldValue - targetValue) > amount)
    		newValue += oldValue < targetValue ? amount : -amount;
    	else
    		newValue = targetValue;
    	oldValue = newValue;
    	return newValue;
    }
}