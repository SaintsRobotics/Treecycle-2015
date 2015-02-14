package org.usfirst.frc.team1899.robot.util;

public class Ramp {
    
    double targetValue;
    final double ratio;
    
    public Ramp(double ratio) {
        this.ratio = ratio;
    }
    
    public double set(double newValue) {
        targetValue = newValue;
        return get();
    }
    
    public double get() {
        return (Math.sin((targetValue-0.5)/Math.PI)+1)/2;
    }
}