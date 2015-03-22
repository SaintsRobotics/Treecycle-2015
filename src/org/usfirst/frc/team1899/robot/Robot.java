
package org.usfirst.frc.team1899.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1899.robot.commands.auton.ForwardDriveCommand;
import org.usfirst.frc.team1899.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1899.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team1899.robot.subsystems.WinchSubsystem;

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
        try {
            CameraServer.getInstance().startAutomaticCapture();
        } catch(Exception e) {
            System.out.println(e);
        }
        drive = new DriveSubsystem();
        winch = new WinchSubsystem();
        gyro = new GyroSubsystem();
        oi = new OI();
        
        gyro.init();
        
        autonCommandSendable = new SendableChooser();
        autonCommandSendable.addDefault("Forward, no platform", new ForwardDriveCommand());
        SmartDashboard.putData("Auton mode", autonCommandSendable);
    }
    
    public void autonomousInit() {
        autonCommand = (Command)autonCommandSendable.getSelected();
        autonCommand.start();
    }
    
    public void teleopInit() {
        autonCommand.cancel();
    }
    
    public void disabledInit() { }
    
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
