package org.usfirst.frc.team1899.robot.commands;

import org.usfirst.frc.team1899.robot.OI.Axis;
import org.usfirst.frc.team1899.robot.OI.Stick;
import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PickupCommand extends Command {

    public PickupCommand() {
        requires(Robot.pickupSubsystem);
    }

    protected void execute() {
        Robot.pickupSubsystem.pickup(
                Robot.oi.getAxisValue(Stick.OPERATOR, Axis.RT),
                Robot.oi.getAxisValue(Stick.OPERATOR, Axis.LT));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
