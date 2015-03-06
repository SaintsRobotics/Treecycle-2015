
package org.usfirst.frc.team1899.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1899.robot.commands.JoystickDriveCommand;
import org.usfirst.frc.team1899.robot.commands.XboxDriveCommand;
import org.usfirst.frc.team1899.robot.commands.auton.ForwardFlatCommand;
import org.usfirst.frc.team1899.robot.commands.auton.SpinCommand;
import org.usfirst.frc.team1899.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1899.robot.subsystems.LifterSubsystem;
import org.usfirst.frc.team1899.robot.subsystems.PickupSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static DriveSubsystem driveSubsystem;
    public static LifterSubsystem lifterSubsystem;
    public static PickupSubsystem pickupSubsystem;
    public static OI oi;
    public static SendableChooser driveCommandSendable;
    public static SendableChooser autonCommandSendable;
    public static Preferences prefs;

    public void robotInit() {
        CameraServer.getInstance().startAutomaticCapture();
        driveSubsystem = new DriveSubsystem();
        lifterSubsystem = new LifterSubsystem();
        pickupSubsystem = new PickupSubsystem();
        oi = new OI();
        
        driveCommandSendable = new SendableChooser();
        driveCommandSendable.addDefault("Joystick Drive", new JoystickDriveCommand());
        driveCommandSendable.addObject("Xbox Drive", new XboxDriveCommand());
        SmartDashboard.putData("Drive mode", driveCommandSendable);
        
        autonCommandSendable = new SendableChooser();
        autonCommandSendable.addDefault("Forward, no platform", new ForwardFlatCommand());
        autonCommandSendable.addObject("Spin", new SpinCommand());
        SmartDashboard.putData("Auton mode", autonCommandSendable);
        
        prefs = Preferences.getInstance();
        prefs.getInt("DRIVE_STICK_1", 0);
        prefs.getInt("DRIVE_STICK_2", 1);
        prefs.getInt("OP_STICK", 2);
    }
    
    public void teleopInit() {
        driveSubsystem.updateCommand();
    }
    public void autonomousInit() { }
    public void disabledInit() { }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
