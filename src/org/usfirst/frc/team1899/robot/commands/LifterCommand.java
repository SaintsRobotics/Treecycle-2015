package org.usfirst.frc.team1899.robot.commands;

import org.usfirst.frc.team1899.robot.OI;
import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LifterCommand extends Command {

    public LifterCommand() {
        requires(Robot.driveSubsystem);
    }

    protected void execute() {
        Robot.lifterSubsystem.lift(Robot.oi.getAxisValue(OI.Stick.DRIVE_1, OI.Axis.TRIGGERS));    
    }    

    protected boolean isFinished() {
        return false;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
