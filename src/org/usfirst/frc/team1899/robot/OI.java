package org.usfirst.frc.team1899.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    Joystick driveStick1 = new Joystick(1);
    Joystick driveStick2 = new Joystick(2);
    
    public enum Stick {
        DRIVE_1, DRIVE_2;
    }
    
    public enum Axis {
        X, Y, Z;
    }
    
    public double getAxisValue(Stick stick, Axis axis) {
        Joystick joystick = null;
        switch (stick) {
            case DRIVE_1:
                joystick = driveStick1;
                break;
            case  DRIVE_2:
                joystick = driveStick2;
                break;
            default:
                return 0;
        }
        
        switch (axis) {
            case X:
                return joystick.getX();
            case Y:
                return joystick.getY();
            case Z:
                return joystick.getZ();
        }
        
        return 0;
    }
}