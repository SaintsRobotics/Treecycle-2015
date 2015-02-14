package org.usfirst.frc.team1899.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static final int MOTOR_FRONT_LEFT = 5; // 0
    public static final int MOTOR_REAR_LEFT = 1;
    public static final int MOTOR_FRONT_RIGHT = 3;
    public static final int MOTOR_REAR_RIGHT = 2; // 5
    
    public static final int WINCH = 4;
    public static final int LEFT_PICKUP = 0;
    public static final int RIGHT_PICKUP = 6;
    
    public static final int SWITCH_TOP = 0;
    public static final int SWITCH_BOTTOM = 9;
    
    public static final int ENCODER_FRONT_RIGHT_A = 1;
    public static final int ENCODER_FRONT_LEFT_A = 2;
    public static final int ENCODER_REAR_RIGHT_A = 3;
    public static final int ENCODER_REAR_LEFT_A = 4;
    
    public static final int ENCODER_FRONT_RIGHT_B = 5;
    public static final int ENCODER_FRONT_LEFT_B = 6;
    public static final int ENCODER_REAR_RIGHT_B = 7;
    public static final int ENCODER_REAR_LEFT_B = 8;
}

// Front Left and Back Right are physically swapped on the robot.