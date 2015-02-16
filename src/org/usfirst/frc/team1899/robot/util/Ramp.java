package org.usfirst.frc.team1899.robot.util;

public class Ramp {
    
    double targetValue;
    final double ratio;
    
    public Ramp(double ratio) {
        this.ratio = ratio;
    }
    
    public double set(double newValue) {
        targetValue = newValue;
        return targetValue;
        //return get();
    }
    
    public double get() {
        return (Math.sin(Math.PI*(targetValue-1.0/2.0))+1)/2;
    }
}