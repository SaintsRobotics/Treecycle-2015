package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.LifterCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSubsystem extends Subsystem {
    
    SpeedController motor;
    AnalogInput topSwitch;
    AnalogInput bottomSwitch;
    Encoder encoder;
        
    public LifterSubsystem() {
        motor = new Talon(RobotMap.WINCH);
        topSwitch = new AnalogInput(RobotMap.SWITCH_TOP);
        bottomSwitch = new AnalogInput(RobotMap.SWITCH_BOTTOM);
        encoder = new Encoder(RobotMap.WINCH_ENCODER_A, RobotMap.WINCH_ENCODER_B);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LifterCommand());
    }
    
    int errSum = 0;
    int lastInput = 0;
    int setpoint = encoder.get();
    double p = 0.5;
    double i = 0;
    double d = 0;
    
    public void lift(double amount) {
        int input = encoder.get();
        if (amount == 0) {
            int error = input - setpoint;
            
            amount = p*error + i*errSum + d*(lastInput-input);
            
            lastInput = input;
        } else {
            errSum = 0;
            setpoint = input;
        }
        if (!isOn(topSwitch) && amount>0)
            motor.set(0);
        else if (!isOn(bottomSwitch) && amount<0)
            motor.set(0);
        else motor.set(amount);
    }
    
    private boolean isOn(AnalogInput limitSwitch) {
        return limitSwitch.getVoltage() > 0.1;
    }
}
