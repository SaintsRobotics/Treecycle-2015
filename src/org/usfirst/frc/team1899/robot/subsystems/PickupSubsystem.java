package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.PickupCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PickupSubsystem extends Subsystem {
    
    SpeedController motorLeft;
    SpeedController motorRight;
    
    public PickupSubsystem() {
        motorLeft = new Talon(RobotMap.LEFT_PICKUP);
        motorRight= new Talon(RobotMap.RIGHT_PICKUP);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new PickupCommand());
    }
    
    public void pickup(double amountLeft, double amountRight) {
    	motorLeft.set(amountLeft);
    	motorRight.set(amountRight);
    }
}
