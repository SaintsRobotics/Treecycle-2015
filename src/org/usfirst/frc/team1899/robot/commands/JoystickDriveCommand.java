package org.usfirst.frc.team1899.robot.commands;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Button;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

/**
 * Controls the robot drive during teleop.
 * 
 * Two Logitech Attach 3 Joysticks.
 * 
 * Left Vertical    : Movement
 * Left Horizontal  : Strafing
 * Right Horizontal : Rotation
 * 
 * Triggers        : Turbo Mode (speed boost)
 * Top Buttons (3) : Slow Mode
 */
public class JoystickDriveCommand extends CommandBase {

    public JoystickDriveCommand() {
        requires(Robot.drive);
    }

    protected void execute() {
        double scale = 0.7;
        if (Robot.oi.getButton(Stick.DRIVE_1, Button.TRIGGER) ||
                Robot.oi.getButton(Stick.DRIVE_2, Button.TRIGGER))
            scale = 1;
        else if (Robot.oi.getButton(Stick.DRIVE_1, Button.BUTTON_3) ||
                Robot.oi.getButton(Stick.DRIVE_2, Button.BUTTON_3))
            scale = 0.25;
        Robot.drive.setMecanumDrive(
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.X)*scale,
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.Y)*scale,
                Robot.oi.getAxisValue(Stick.DRIVE_2, Axis.X)*scale, 0);
    }
}