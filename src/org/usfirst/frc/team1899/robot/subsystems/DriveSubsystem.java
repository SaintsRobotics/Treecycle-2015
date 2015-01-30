package org.usfirst.frc.team1899.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;
import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.DriveCommand;

public class DriveSubsystem extends Subsystem {
	
	RobotDrive robotDrive = new RobotDrive(
			RobotMap.MOTOR_FRONT_LEFT, RobotMap.MOTOR_REAR_LEFT,
			RobotMap.MOTOR_FRONT_RIGHT, RobotMap.MOTOR_REAR_RIGHT);

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveCommand());
    }
    
    public void setMecanumDrive(double kX, double kY, double rotation) {
    	robotDrive.mecanumDrive_Cartesian(
    			Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.X),
    			Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.Y),
    			Robot.oi.getAxisValue(Stick.DRIVE_2, Axis.Y), 0);
    }
}
