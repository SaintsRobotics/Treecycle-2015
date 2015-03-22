package com.saintsrobotics.treecycle.commands.auton;

import com.saintsrobotics.treecycle.Robot;

/**
 * Drives the robot forward. Gets the minimum required 
 * 
 */
public class ForwardDriveCommand extends TimedCommand {
    
    public ForwardDriveCommand() {
        super(Robot.drive, 2000);
    }
    
    @Override
    protected void execute() {
        Robot.drive.setMecanumDrive(0, 0.5, 0, 0);
    }
}
