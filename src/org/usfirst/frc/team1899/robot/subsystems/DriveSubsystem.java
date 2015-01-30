package org.usfirst.frc.team1899.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;
import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.DriveCommand;

public class DriveSubsystem extends Subsystem {
    
	SpeedController right1 = new Talon(RobotMap.MOTOR_RIGHT_1);
    SpeedController right2 = new Talon(RobotMap.MOTOR_RIGHT_2);
    SpeedController left1 = new Talon(RobotMap.MOTOR_LEFT_1);
    SpeedController left2 = new Talon(RobotMap.MOTOR_LEFT_2);
	
	RobotDrive robotDrive = new RobotDrive(1, 2, 3, 4);

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
