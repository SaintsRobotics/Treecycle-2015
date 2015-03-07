package org.usfirst.frc.team1899.robot.commands.auton;

import org.usfirst.frc.team1899.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ForwardFlatCommand extends Command {
    
    Timer timer = new Timer();
    
    public ForwardFlatCommand() {
        requires(Robot.driveSubsystem);
    }

    protected void initialize() {
        timer.start();        
    }
    
    protected void execute() {
        System.out.println("Exec : " + timer.get());
        Robot.driveSubsystem.setMecanumDrive(0, 0.4, 0, 0); // y is inverted
    }

    protected boolean isFinished() {
        System.out.println("Final: " + timer.get());
        return timer.get() > 3.5;
    }

    protected void end() {
        Robot.driveSubsystem.stop();
        timer.stop();
    }
    
    protected void interrupted() {  }
}
