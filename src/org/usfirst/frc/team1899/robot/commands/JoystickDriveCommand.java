package org.usfirst.frc.team1899.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

public class JoystickDriveCommand extends Command {

    public JoystickDriveCommand() {
        requires(Robot.driveSubsystem);
    }

    protected void execute() {
        Robot.driveSubsystem.setMecanumDrive(
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.Y),
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.X),
                Robot.oi.getAxisValue(Stick.DRIVE_2, Axis.X), 0);
    }    

    protected boolean isFinished() {
        return false;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
