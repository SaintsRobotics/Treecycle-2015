package org.usfirst.frc.team1899.robot.util;

import edu.wpi.first.wpilibj.Talon;

public class TalonMotor {
    
    Talon talon;
    Ramp ramp;
    
    public TalonMotor(int channel) {
        talon = new Talon(channel);
        ramp = new Ramp(0.5);
    }
    
    public void set(double val) {
        val = ramp.set(val);
        talon.set(val);
    }
}
