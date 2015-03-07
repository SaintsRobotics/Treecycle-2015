package org.usfirst.frc.team1899.robot.util;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

public class TalonMotor {
    
    Talon talon;
    Ramp ramp;
    Encoder encoder;
    boolean inverted;
    
    public TalonMotor(int motorPin, int aChannel, int bChannel, boolean inv) {
        talon = new Talon(motorPin);
        ramp = new Ramp(0.2);
        encoder = new Encoder(aChannel, bChannel);
        inverted = inv;
    }
    
    public void set(double val) {
        val = inverted ? -val : val;
        val = ramp.rampValues(val);
        talon.set(val);
    }

    public void stop() {
        talon.set(0);
    }
}
