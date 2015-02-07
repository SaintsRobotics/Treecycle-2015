package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.XboxDriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
    
    RobotDrive robotDrive = new RobotDrive(
            RobotMap.MOTOR_FRONT_LEFT, RobotMap.MOTOR_REAR_LEFT,
            RobotMap.MOTOR_FRONT_RIGHT, RobotMap.MOTOR_REAR_RIGHT);

    public void initDefaultCommand() {
        setDefaultCommand(new XboxDriveCommand());
    }
    
    public void setMecanumDrive(double x, double y, double rotation, double gyro) {
        robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyro);
    }
}
