package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.WinchCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

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
    private AnalogInput topSwitch = new AnalogInput(RobotMap.SWITCH_TOP);
    private AnalogInput bottomSwitch = new AnalogInput(RobotMap.SWITCH_BOTTOM);
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new WinchCommand());
    }
    
    /**
     * Moves the winch at the specified speed, unless the hook
     * is at the top or bottom, calculated by the limit switches
     * and by the encoder, if it exists.
     * 
     * @param speed The speed to move the winch.
     */
    public void lift(double speed) {
        if (encoder.getStopped()) {
            if (!isOn(bottomSwitch) && speed>0)
                motor.set(0);
            else if (!isOn(topSwitch) && speed<0)
                motor.set(0);
            else motor.set(speed);
        } else {
            if (!isOn(bottomSwitch) && speed>0)
                motor.set(0);
            else if (!isOn(topSwitch) && speed<0)
                motor.set(0);
            else motor.set(speed);
        }
    }
    
    /**
     * Internal method to tell if a limit switch in an analog port is on.
     * 
     * Analog ports measure the voltage of the input. This method checks
     * the voltage and returns if the switch is pressed.
     */
    private boolean isOn(AnalogInput limitSwitch) {
        return limitSwitch.getVoltage() > 0.1;
    }
}
