package org.usfirst.frc.team1899.robot.util;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class TalonMotor {
    
    Talon talon;
    Ramp ramp;
    Encoder encoder;
    
    public TalonMotor(int motorPin, int aChannel, int bChannel) {
        talon = new Talon(motorPin);
        ramp = new Ramp(0.5);
        encoder = new Encoder(aChannel, bChannel);
    }
    
    public void set(double val) {
        val = ramp.set(val);
        talon.set(val);
    }
}
