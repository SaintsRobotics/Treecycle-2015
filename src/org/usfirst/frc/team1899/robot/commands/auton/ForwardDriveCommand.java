package org.usfirst.frc.team1899.robot.commands.auton;

import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

/**
 * Drives the robot forward. Gets the minimum required 
 * 
 */
public class ForwardDriveCommand extends TimedCommand {
    
    Timer timer = new Timer();
    
    public ForwardDriveCommand() {
        super(Robot.drive, 2000);
    }
    
    @Override
    protected void execute() {
        Robot.drive.setMecanumDrive(0, 0.5, 0, 0);
    }
}
