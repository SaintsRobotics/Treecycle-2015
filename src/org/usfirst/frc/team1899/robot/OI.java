package org.usfirst.frc.team1899.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    Joystick driveStick1 = new Joystick(0);
    Joystick driveStick2 = new Joystick(1);
    Joystick driveStick3 = new Joystick(2);
    
    public enum Stick {
        DRIVE_1, DRIVE_2, DRIVE_3;
    }
    
    public enum Axis {
        X, Y, Z, LX, LY, RX, RY, LT, RT, TRIGGERS;
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
            case DRIVE_3:
                joystick = driveStick3;
                break;
            default:
                return 0;
        }
        
        double val = 0;
        switch (axis) {
            case X:
                val = joystick.getX();
                break;
            case Y:
                val = joystick.getY();
                break;
            case Z:
                val = joystick.getZ();
                break;
            case LX:
                val = joystick.getRawAxis(0);
                break;
            case LY:
                val = joystick.getRawAxis(1);
                break;
            case LT:
                val = joystick.getRawAxis(2);
                break;
            case RT:
                val = joystick.getRawAxis(3);
                break;
            case RX:
                val = joystick.getRawAxis(4);
                break;
            case RY:
                val = joystick.getRawAxis(5);
                break;
            case TRIGGERS:
                val = joystick.getRawAxis(3) - joystick.getRawAxis(2);
                break;
        }
        
        return Math.abs(val) < 0.13 ? 0 : val;
    }
}