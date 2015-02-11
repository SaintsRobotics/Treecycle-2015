package org.usfirst.frc.team1899.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static final int MOTOR_FRONT_LEFT = 2;
    public static final int MOTOR_REAR_LEFT = 1;
    public static final int MOTOR_FRONT_RIGHT = 3;
    public static final int MOTOR_REAR_RIGHT = 0;
    
    public static final int WINCH = 4;
    public static final int LEFT_WING = 5;
    public static final int RIGHT_WING = 6;
    
    public static final int SWITCH_TOP = 0;
    public static final int SWITCH_BOTTOM = 1;
}

// Front Left and Back Right are physically swapped on the robot.