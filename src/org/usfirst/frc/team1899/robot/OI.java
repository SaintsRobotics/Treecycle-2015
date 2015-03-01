package org.usfirst.frc.team1899.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    Joystick driveStick1 = new Joystick(0);
    Joystick driveStick2 = new Joystick(1);
    Joystick operatorStick = new Joystick(2);
    
    public enum Stick {
        DRIVE_1, DRIVE_2, OPERATOR;
    }
    
    public enum Axis {
        X, Y, Z, LX, LY, RX, RY, LT, RT, TRIGGERS;
    }
    
    public enum Button {
        A, B, X, Y, RB, LB, START, SELECT, R3, L3, TRIGGER, B3;
    }
    
    public boolean getButton(Stick stick, Button button) {
        Joystick joystick = null;
        switch (stick) {
            case DRIVE_1:
                joystick = driveStick1;
                break;
            case DRIVE_2:
                joystick = driveStick2;
                break;
            case OPERATOR:
                joystick = operatorStick;
                break;
            default:
                return false;
        }
        
        switch (button) {
            case RB:
                return joystick.getRawButton(6);
            case LB:
                return joystick.getRawButton(5);
            case TRIGGER:
                return joystick.getRawButton(1);
            case B3:
                return joystick.getRawButton(3);
            default:
                return false;
        }
    }
    
    public double getAxisValue(Stick stick, Axis axis) {
        Joystick joystick = null;
        switch (stick) {
            case DRIVE_1:
                joystick = driveStick1;
                break;
            case DRIVE_2:
                joystick = driveStick2;
                break;
            case OPERATOR:
            	joystick = operatorStick;
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