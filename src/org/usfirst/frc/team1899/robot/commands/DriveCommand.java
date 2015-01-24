
package org.usfirst.frc.team1899.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;


//import org.usfirst.frc.team1899.robot.OI;
import org.usfirst.frc.team1899.robot.Robot;
//import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.DriveCommand;
//import org.usfirst.frc.team1899.robot.subsystems.DriveSubsystem;

//import org.usfirst.frc.team1899.robot.Robot;

/**
 *
 */
public class DriveCommand extends Command {
	
	RobotDrive robotDrive = new RobotDrive(1, 2, 3, 4);

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.exampleSubsystem);
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSubsystem.setMecanumDrive();
    	//robotDrive.mecanumDrive_Cartesian(Robot.oi.getAxisValue(1), Robot.oi.getAxisValue(2), rotation, gyroAngle);
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
