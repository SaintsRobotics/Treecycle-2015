package org.usfirst.frc.team1899.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Button;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

public class JoystickDriveCommand extends Command {

    public JoystickDriveCommand() {
        requires(Robot.driveSubsystem);
    }

    protected void execute() {
        double scale = 1;
        if (Robot.oi.getButton(Stick.DRIVE_1, Button.TRIGGER) ||
                Robot.oi.getButton(Stick.DRIVE_2, Button.TRIGGER) ||
                Robot.oi.getButton(Stick.DRIVE_1, Button.B3) ||
                Robot.oi.getButton(Stick.DRIVE_2, Button.B3))
            scale = 0.25;
        Robot.driveSubsystem.setMecanumDrive(
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.X)*scale,
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.Y)*scale,
                Robot.oi.getAxisValue(Stick.DRIVE_2, Axis.X)*scale, 0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
