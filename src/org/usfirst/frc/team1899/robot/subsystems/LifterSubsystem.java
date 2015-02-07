package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.LifterCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterSubsystem extends Subsystem {
    
    SpeedController motor;
    
    public LifterSubsystem() {
        motor = new Talon(RobotMap.WINCH);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LifterCommand());
    }
    
    public void lift(double amount) {
        motor.set(amount);
    }
}
