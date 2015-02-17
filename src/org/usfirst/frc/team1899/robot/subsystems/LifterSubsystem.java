package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.LifterCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSubsystem extends Subsystem {
    
    SpeedController motor;
    AnalogInput topSwitch;
    AnalogInput bottomSwitch;
    
    public LifterSubsystem() {
        motor = new Talon(RobotMap.WINCH);
        topSwitch = new AnalogInput(RobotMap.SWITCH_TOP);
        bottomSwitch = new AnalogInput(RobotMap.SWITCH_BOTTOM);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LifterCommand());
    }
    
    public void lift(double amount) {
        if (!isOn(topSwitch) && amount>0)
            motor.set(0);
        else if (!isOn(bottomSwitch) && amount<0)
            motor.set(0);
        else motor.set(amount);
    }
    
    private boolean isOn(AnalogInput limitSwitch) {
        return limitSwitch.getVoltage() > 2.5;
    }
}
