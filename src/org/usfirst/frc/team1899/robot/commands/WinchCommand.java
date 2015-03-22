package org.usfirst.frc.team1899.robot.commands;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Button;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

/**
 * Controls the winch during teleop.
 * 
 * One Xbox 360 Controller.
 * 
 * Left Vertical Axis: Winch control.
 * RB: Turbo mode (increased speed).
 */
public class WinchCommand extends CommandBase {

    public WinchCommand() {
        requires(Robot.winch);
    }
    
    protected void execute() {
        double scale = Robot.oi.getButton(Stick.OPERATOR, Button.RB)? 1 : 0.6;
        Robot.winch.lift(Robot.oi.getAxisValue(Stick.OPERATOR, Axis.LY)*scale);
    }
}
