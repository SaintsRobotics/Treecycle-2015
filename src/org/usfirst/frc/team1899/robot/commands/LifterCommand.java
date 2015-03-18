package org.usfirst.frc.team1899.robot.commands;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Button;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LifterCommand extends Command {

    public LifterCommand() {
        requires(Robot.lifterSubsystem);
    }

    protected void initialize() {
        Robot.lifterSubsystem.init();
    }
    
    protected void execute() {
        Robot.lifterSubsystem.lift(Robot.oi.getAxisValue(Stick.OPERATOR, Axis.LY)
                *(Robot.oi.getButton(Stick.OPERATOR, Button.RB)?1:0.6));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() { }
    protected void interrupted() {  }
}
