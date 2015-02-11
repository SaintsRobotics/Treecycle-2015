package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.LifterCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSubsystem extends Subsystem {
    
    SpeedController motor;
    DigitalInput topSwitch;
    DigitalInput bottomSwitch;
    
    public LifterSubsystem() {
        motor = new Talon(RobotMap.WINCH);
        topSwitch = new DigitalInput(RobotMap.SWITCH_TOP);
        bottomSwitch = new DigitalInput(RobotMap.SWITCH_BOTTOM);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LifterCommand());
    }
    
    public void lift(double amount) {
        if (!topSwitch.get() && amount>0)
            motor.set(0);
        else if (!bottomSwitch.get() && amount<0)
            motor.set(0);
        else motor.set(amount);
    }
}
