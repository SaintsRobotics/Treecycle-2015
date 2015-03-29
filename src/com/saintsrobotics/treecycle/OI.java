package com.saintsrobotics.treecycle;

import edu.wpi.first.wpilibj.Joystick;

/** Operator Interface. Gets input from joysticks. */
public class OI {
    
    // Logitech Attack 3 Joysticks
    Joystick driveStick1 = new Joystick(0);
    Joystick driveStick2 = new Joystick(1);
    
    // Xbox Controller
    Joystick operatorStick = new Joystick(2);
    
    public enum Stick {
        DRIVE_1, DRIVE_2, OPERATOR;
    }
    
    public enum Axis {
        // XBOX
        LX, LY, RX, RY, LT, RT, TRIGGERS,
        
        // JOYSTICK
        X, Y, Z;
    }
    
    public enum Button {
        // XBOX
        A, B, X, Y, RB, LB, START, SELECT, R3, L3,
        
        // JOYSTICK
        TRIGGER, BUTTON_3;
    }
    
    /**
     * Gets the current state of a button.
     * 
     * @param stick The joystick the button is on.
     * @param button The button to get the state of.
     * @return true if the button is down, false if it's up.
     */
    public boolean getButton(Stick stick, Button button) {
        Joystick joystick = getStick(stick);
        
        switch (button) {
            case A:
                return joystick.getRawButton(1);
            case B:
                return joystick.getRawButton(2);
            case RB:
                return joystick.getRawButton(6);
            case LB:
                return joystick.getRawButton(5);
            case TRIGGER:
                return joystick.getRawButton(1);
            case BUTTON_3:
                return joystick.getRawButton(3);
            default:
                return false;
        }
    }
    
    /**
     * Gets the current value of an axis. Small values
     * are deadzoned to zero.
     * 
     * @param stick The joystick the axis is on.
     * @param axis The axis to get the state of.
     * @return The value of the axis, -1.0 to 1.0.
     */
    public double getAxisValue(Stick stick, Axis axis) {
        double val = getRawAxis(getStick(stick), axis);
        return Math.abs(val) < 0.13 ? 0 : val;
    }
    
    /** Gets a Joystick object from a Stick enum item, utility. */
    private Joystick getStick(Stick stick) {
        switch (stick) {
            case DRIVE_1:
                return driveStick1;
            case DRIVE_2:
                return driveStick2;
            case OPERATOR:
                return operatorStick;
            default:
                return null;
        }
    }
    
    /** Gets a raw non-deadzoned axis value, utility. */
    private double getRawAxis(Joystick joystick, Axis axis) {
        switch (axis) {
            case X:
                return joystick.getX();
            case Y:
                return joystick.getY();
            case Z:
                return joystick.getZ();
            case LX:
                return joystick.getRawAxis(0);
            case LY:
                return joystick.getRawAxis(1);
            case LT:
                return joystick.getRawAxis(2);
            case RT:
                return joystick.getRawAxis(3);
            case RX:
                return joystick.getRawAxis(4);
            case RY:
                return joystick.getRawAxis(5);
            case TRIGGERS:
                return joystick.getRawAxis(3) - joystick.getRawAxis(2);
            default:
                return 0;
        }
    }
}