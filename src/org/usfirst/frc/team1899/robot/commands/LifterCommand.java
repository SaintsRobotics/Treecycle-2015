package org.usfirst.frc.team1899.robot.commands;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LifterCommand extends Command {

    public LifterCommand() {
        requires(Robot.lifterSubsystem);
    }

    protected void execute() {
        Robot.lifterSubsystem.lift(Robot.oi.getAxisValue(Stick.DRIVE_3, Axis.LY));    //Stick 3 is XboX controller for operator
    }

    protected boolean isFinished() {
        return false;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
