package org.usfirst.frc.team1899.robot.subsystems;

import org.usfirst.frc.team1899.robot.Robot;
import org.usfirst.frc.team1899.robot.RobotMap;
import org.usfirst.frc.team1899.robot.util.MathHelper;
import org.usfirst.frc.team1899.robot.util.TalonMotor;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
    
    TalonMotor frontRight = new TalonMotor(RobotMap.MOTOR_FRONT_RIGHT,
            RobotMap.ENCODER_FRONT_RIGHT_A, RobotMap.ENCODER_FRONT_RIGHT_B, true);
    TalonMotor frontLeft = new TalonMotor(RobotMap.MOTOR_FRONT_LEFT,
            RobotMap.ENCODER_FRONT_LEFT_A, RobotMap.ENCODER_FRONT_LEFT_B, true);
    TalonMotor rearRight = new TalonMotor(RobotMap.MOTOR_REAR_RIGHT,
            RobotMap.ENCODER_REAR_RIGHT_A, RobotMap.ENCODER_REAR_RIGHT_B, true);
    TalonMotor rearLeft = new TalonMotor(RobotMap.MOTOR_REAR_LEFT,
            RobotMap.ENCODER_REAR_LEFT_A, RobotMap.ENCODER_REAR_LEFT_B, false);

    public void initDefaultCommand() {
    }
    
    public void updateCommand() {
        setDefaultCommand((Command)Robot.driveCommandSendable.getSelected());        
    }
    
    public void stop() {
        frontLeft.stop();
        frontRight.stop();
        rearLeft.stop();
        rearRight.stop();
    }
    
    /**
     * Does mecanum drive.
     * 
     * @param x the absolute x velocity
     * @param y the absolute y velocity
     * @param rotation the speed to rotate, from -1.0 to 1.0
     * @param gyroAngle the gyro angle to adjust the headings to be absolute
     */
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
