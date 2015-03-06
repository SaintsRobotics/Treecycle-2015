package org.usfirst.frc.team1899.robot.commands.auton;

import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ForwardFlatCommand extends Command {
    
    Timer timer = new Timer();
    
    public ForwardFlatCommand() {
        requires(Robot.driveSubsystem);
        timer.start();
    }

    protected void execute() {
        Robot.driveSubsystem.setMecanumDrive(0.5, 0, 0, 0);
    }

    protected boolean isFinished() {
        return timer.get() < 1;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
