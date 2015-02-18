package org.usfirst.frc.team1899.robot.util;

public class Ramp {
    
    double targetValue;
    double newValue;
    
    public Ramp(double targetValue) {
    	this.targetValue = targetValue;
    }
    
    public double rampValues(double oldValue, double targetValue) {
    	if(Math.abs(oldValue - targetValue) > 0.5){
    		if(oldValue < targetValue) newValue = oldValue + 0.5;
    		else newValue = oldValue - 0.5;
    	}
    	return newValue;
    }
    
    public double get() {
    	
        //return (Math.sin(Math.PI*(targetValue-1.0/2.0))+1)/2;
    }
}