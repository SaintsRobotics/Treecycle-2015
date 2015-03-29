package com.saintsrobotics.treecycle;

import com.saintsrobotics.treecycle.commands.CameraCommand;
import com.saintsrobotics.treecycle.commands.auton.PullTwoLandfillCommand;
import com.saintsrobotics.treecycle.subsystems.DriveSubsystem;
import com.saintsrobotics.treecycle.subsystems.GyroSubsystem;
import com.saintsrobotics.treecycle.subsystems.WinchSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static DriveSubsystem drive;
    public static WinchSubsystem winch;
    public static GyroSubsystem gyro;
    public static OI oi;
    
    private SendableChooser autonCommandSendable;
    private Command autonCommand;

    public void robotInit() {
        drive = new DriveSubsystem();
        winch = new WinchSubsystem();
        gyro = new GyroSubsystem();
        oi = new OI();
        
        gyro.init();
        
        autonCommandSendable = new SendableChooser();
        autonCommandSendable.addDefault("Forward, no platform", new PullTwoLandfillCommand());
        SmartDashboard.putData("Auton mode", autonCommandSendable);
        
        //new CameraCommand().start();
        CameraServer.getInstance().startAutomaticCapture();
    }
    
    public void autonomousInit() {
        autonCommand = new PullTwoLandfillCommand();
        autonCommand.start();
    }
    
    public void teleopInit() {
        if (autonCommand != null)
            autonCommand.cancel();
    }
    
    public void disabledInit() {
        Robot.winch.reset();
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
