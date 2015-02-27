/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc5107.commands;


/**
 *
 * @author BITKRUSHER
 */
public class ClawOpen extends CommandBase {
    
    /**
     * Initialize the command so that it requires the claw. This means it will
     * be interrupted if another command requiring the claw is run.
     */
    public ClawOpen() {
        requires(claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        claw.clawOff();
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Tells the claw to do nothing, stopping any previous movement.
     */
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    /**
     * @return false, so that it executes forever or until another command
     *         interrupts it.
     */
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}