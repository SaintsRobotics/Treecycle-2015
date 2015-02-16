package org.usfirst.frc.team1899.robot.commands;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class XboxDriveCommand extends Command {

    public XboxDriveCommand() {
        requires(Robot.driveSubsystem);
    }

    protected void execute() {
        Robot.driveSubsystem.setMecanumDrive(
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.LX),
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.LY),
                Robot.oi.getAxisValue(Stick.DRIVE_1, Axis.RX), 0);
    }    

    protected boolean isFinished() {
        return false;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
