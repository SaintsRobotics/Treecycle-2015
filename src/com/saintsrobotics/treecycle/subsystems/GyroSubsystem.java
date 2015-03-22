package com.saintsrobotics.treecycle.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The gyroscope on the robot, used primarily to orient
 * the robot during autonomous.
 */
public class GyroSubsystem extends Subsystem {
    
    private Gyro gyro = new Gyro(0);
    
    @Override
    protected void initDefaultCommand() { }
    
    /**
     * Initialized the gyroscope. Must be called before
     * moving the robot or pulling data as this ensures
     * that the gyroscope is initialized to a value of
     * zero. Takes multiple samples to fully initialize.
     * 
     * This method can be called again to reset the
     * orientation of the robot.
     */
    public void init() {
        gyro.initGyro();
    }
    
    /** @return The current angle of the gyro. */
    public double getAngle() {
        return gyro.getAngle();
    }
    
    /** @return The rate of rotation of the gyro. */
    public double getRate() {
        return gyro.getRate();
    }
}
