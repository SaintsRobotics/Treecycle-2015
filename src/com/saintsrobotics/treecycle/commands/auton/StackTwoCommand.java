package com.saintsrobotics.treecycle.commands.auton;

import com.saintsrobotics.treecycle.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * WORK IN PROGRESS! Probably won't ever get finished :(.
 * 
 * Going right to left, grabs an auton tote, moves forward,
 * and drops the tote on a second tote. Obviously ignores the
 * garbage cans in the way :P.
 */
public class StackTwoCommand extends CommandGroup {
    
    public StackTwoCommand() {
        addSequential(new TimedCommand(Robot.winch, 1000) {
            @Override
            protected void execute() {
                Robot.winch.lift(0.5);
            }
        });
        addSequential(new TimedCommand(Robot.drive, 1000) {
            @Override
            protected void execute() {
                Robot.drive.driveStraight(0.5, Robot.gyro.getRate());
            }
        });
        addSequential(new TimedCommand(Robot.winch, 1000) {
            @Override
            protected void execute() {
                Robot.winch.lift(-0.5);
            }
        });
    }
}