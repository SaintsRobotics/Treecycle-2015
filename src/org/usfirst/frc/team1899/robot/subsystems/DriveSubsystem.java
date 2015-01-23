package org.usfirst.frc.team1899.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team1899.robot.OI;
import org.usfirst.frc.team1899.robot.Robot;
import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.DriveCommand;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
	SpeedController right1 = new Talon(RobotMap.MOTOR_RIGHT_1);
    SpeedController right2 = new Talon(RobotMap.MOTOR_RIGHT_2);
    SpeedController left1 = new Talon(RobotMap.MOTOR_LEFT_1);
    SpeedController left2 = new Talon(RobotMap.MOTOR_LEFT_2);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	// Create a RobotDrive object using PWMS 1, 2, 3, and 4
	RobotDrive robotDrive = new RobotDrive(1, 2, 3, 4);
	// Define joystick being used at USB port #1 on the Drivers Station


    public void initDefaultCommand() {
    	setDefaultCommand(new DriveCommand());
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    			// Twist is on Axis 3 for the Extreme 3D Pro
    			//m_driveStick->SetAxisChannel(Joystick::kTwistAxis, 3);
    }
    
    public void setMecanumDrive(double magnitude, double direction, double rotation) {
    	int gyroAngle = 0;
    	robotDrive.mecanumDrive_Cartesian(Robot.oi.getAxisValue(1), Robot.oi.getAxisValue(2), rotation, gyroAngle);
    }
}
