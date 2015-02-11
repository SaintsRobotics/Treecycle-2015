package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.commands.JoystickDriveCommand;
import org.usfirst.frc.team1899.robot.util.MathHelper;
import org.usfirst.frc.team1899.robot.util.TalonMotor;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
    
    TalonMotor frontRight = new TalonMotor(RobotMap.MOTOR_FRONT_RIGHT);
    TalonMotor frontLeft = new TalonMotor(RobotMap.MOTOR_FRONT_LEFT);
    TalonMotor rearRight = new TalonMotor(RobotMap.MOTOR_REAR_RIGHT);
    TalonMotor rearLeft = new TalonMotor(RobotMap.MOTOR_REAR_LEFT);

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDriveCommand());
    }
    
    public void setMecanumDrive(double x, double y, double rotation, double gyroAngle) {
        y = -y;
        
        double rotated[] = MathHelper.rotateVector(x, y, gyroAngle);
        x = rotated[0];
        y = rotated[1];

        double wheelSpeeds[] = new double[4];
        wheelSpeeds[0] =  x + y + rotation;
        wheelSpeeds[1] = -x + y - rotation;
        wheelSpeeds[2] = -x + y + rotation;
        wheelSpeeds[3] =  x + y - rotation;

        MathHelper.normalize(wheelSpeeds);
        frontLeft.set(wheelSpeeds[0]);
        frontRight.set(wheelSpeeds[1]);
        rearLeft.set(wheelSpeeds[2]);
        rearRight.set(wheelSpeeds[3]);
    }
}
