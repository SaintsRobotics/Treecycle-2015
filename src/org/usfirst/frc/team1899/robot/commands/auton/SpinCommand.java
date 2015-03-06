package org.usfirst.frc.team1899.robot.commands.auton;

import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SpinCommand extends Command {
    
    Timer timer = new Timer();
    
    public SpinCommand() {
        requires(Robot.driveSubsystem);
        timer.start();
    }

    protected void execute() {
        Robot.driveSubsystem.setMecanumDrive(0, 0, 0.5, 0);
    }

    protected boolean isFinished() {
        return timer.get() < 1;
    }

    protected void initialize() { }
    protected void end() { }
    protected void interrupted() {  }
}
