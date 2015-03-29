package com.saintsrobotics.treecycle.commands.auton;

import com.saintsrobotics.treecycle.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 */
public class PullTwoLandfillCommand extends CommandGroup {
    
    public PullTwoLandfillCommand() {
        addSequential(new TimedCommand(Robot.drive, 2000) { // Drive forward
            protected void execute() {
                Robot.drive.driveStraight(0.5, Robot.gyro.getRate());
            }
            protected void end() {
                Robot.drive.stop();
            }
        });
        addSequential(new TimedCommand(Robot.winch, 1000) {   // Hook up
            protected void execute() {
                Robot.winch.lift(-0.5);
            }
            protected void end() {
                Robot.winch.stop();
            }
        });
        addSequential(new TimedCommand(1000) {              // Filler
            protected void execute() { }
        });
        addSequential(new TimedCommand(Robot.drive, 2000) { // Drive back
            protected void execute() {
                Robot.drive.driveStraight(-0.5, -Robot.gyro.getRate());
            }
            protected void end() {
                Robot.drive.stop();
            }
        });
    }
}