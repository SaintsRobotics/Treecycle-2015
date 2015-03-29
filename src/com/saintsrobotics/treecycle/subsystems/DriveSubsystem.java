package com.saintsrobotics.treecycle.subsystems;

import com.saintsrobotics.treecycle.RobotMap;
import com.saintsrobotics.treecycle.commands.JoystickDriveCommand;
import com.saintsrobotics.treecycle.util.MathHelper;
import com.saintsrobotics.treecycle.util.TalonMotor;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Handles the drivetrain of the robot.
 */
public class DriveSubsystem extends Subsystem {
    
    TalonMotor frontRight = new TalonMotor(RobotMap.MOTOR_FRONT_RIGHT, true);
    TalonMotor frontLeft = new TalonMotor(RobotMap.MOTOR_FRONT_LEFT, true);
    TalonMotor rearRight = new TalonMotor(RobotMap.MOTOR_REAR_RIGHT, true);
    TalonMotor rearLeft = new TalonMotor(RobotMap.MOTOR_REAR_LEFT, false);

    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDriveCommand());
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
    
    /**
     * Drives straight, adjusting for curve values from gyro.
     * 
     * @param speed The speed to drive.
     * @param curve The value read from the gyro.
     */
    public void driveStraight(double speed, double curve) {
        curve = -curve;
        double leftOutput, rightOutput;

        if (curve < 0) {
            double value = Math.log(-curve);
            double ratio = (value - 0.5) / (value + 0.5);
            if (ratio == 0)
                ratio = .0000000001;
            leftOutput = speed / ratio;
            rightOutput = speed;
        } else if (curve > 0) {
            double value = Math.log(curve);
            double ratio = (value - 0.5) / (value + 0.5);
            if (ratio == 0)
                ratio = .0000000001;
            leftOutput = speed;
            rightOutput = speed / ratio;
        } else {
            leftOutput = speed;
            rightOutput = speed;
        }
        frontLeft.set(leftOutput);
        rearLeft.set(leftOutput);
        frontRight.set(rightOutput);
        rearRight.set(rightOutput);
    }
    
    /**
     * Force stops all of the drive motors.
     */
    public void stop() {
        frontLeft.stop();
        frontRight.stop();
        rearLeft.stop();
        rearRight.stop();
    }
}
