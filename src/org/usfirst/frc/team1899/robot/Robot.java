
package org.usfirst.frc.team1899.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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

    public void robotInit() {
        driveSubsystem = new DriveSubsystem();
        lifterSubsystem = new LifterSubsystem();
        pickupSubsystem = new PickupSubsystem();
        oi = new OI();
    }
    
    public void autonomousInit() { }
    public void teleopInit() { }
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
