package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.PickupCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PickupSubsystem extends Subsystem {
    
    SpeedController motor;
    
    public PickupSubsystem() {
        motor = new Talon(RobotMap.WINCH);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new PickupCommand());
    }
    
    public void pickup(double amount) {
    	motor.set(amount);
    }
}
