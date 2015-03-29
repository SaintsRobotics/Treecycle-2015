package com.saintsrobotics.treecycle.subsystems;

import com.saintsrobotics.treecycle.RobotMap;
import com.saintsrobotics.treecycle.commands.WinchCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Handles the winch, which is a simple pulley system with 
 * a single Talon.
 * 
 * There are two switches at the top and bottom to prevent
 * the hook from going too far.
 */
public class WinchSubsystem extends Subsystem {
    
    private SpeedController motor = new Talon(RobotMap.WINCH);
    private Encoder encoder = new Encoder(RobotMap.WINCH_ENCODER_A, RobotMap.WINCH_ENCODER_B);
    private DigitalInput topSwitch = new DigitalInput(RobotMap.SWITCH_TOP);
    private DigitalInput bottomSwitch = new DigitalInput(RobotMap.SWITCH_BOTTOM);
    
    public static final int ENCODER_BOUND_BOTTOM = 0;
    public static final int ENCODER_BOUND_TOP = 10000;
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new WinchCommand());
    }
    
    /**
     * Moves the winch at the specified speed, unless the hook
     * is at the top or bottom, calculated by the limit switches.
     * 
     * @param speed The speed to move the winch.
     */
    public void lift(double speed) {
        speed = -speed;
        if (speed>0 && !topSwitch.get())
            motor.set(0);
        else if (speed<0 && !bottomSwitch.get())
            motor.set(0);
        else motor.set(speed);
    }
    
    /**
     * Moves the winch at the specified speed, unless the hook
     * is at the top or bottom, calculated by the limit switches
     * and by the encoder.
     * 
     * @param speed The speed to move the winch.
     */
    public void liftEncoder(double speed) {
        speed = -speed;
        SmartDashboard.putString("DB/String 0", String.valueOf(encoder.get()));
        if (speed>0 && (!topSwitch.get() || encoder.get()>ENCODER_BOUND_TOP))
            motor.set(0);
        else if (speed<0 && (!bottomSwitch.get() || encoder.get()<ENCODER_BOUND_BOTTOM))
            motor.set(0);
        else motor.set(speed);
    }
    
    public void reset() {
        encoder.reset();
    }

    public void stop() {
        motor.set(0);
    }
}
