package com.saintsrobotics.treecycle.commands.auton;

import com.saintsrobotics.treecycle.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An abstract class that's easy to instantiate inline.
 * Makes it easy to run a certain behavior for a certain
 * period of time.
 */
public abstract class TimedCommand extends CommandBase {
    
    /**
     * Create a new TimedCommand that runs for the specified
     * period of time, without susbsytem dependencies.
     * 
     * @param time The time, in milliseconds, to run for.
     */
    public TimedCommand(double time) {
        this.setTimeout(time/1000.0);
    }
    
    /**
     * Create a new TimedCommand that runs for the specified
     * period of time, passing a subsystem dependency.
     * 
     * @param req A subsystem to require.
     * @param time The time, in milliseconds, to run for.
     */
    public TimedCommand(Subsystem req, double time) {
        this(time);
        if (req != null)
            requires(req);
    }

    protected abstract void execute();
    
    @Override
    protected boolean isFinished() {
        return this.isTimedOut();
    }
}
