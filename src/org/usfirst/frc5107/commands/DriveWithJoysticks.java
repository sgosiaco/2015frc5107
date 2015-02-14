/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc5107.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 * @author BITKRUSHER
 */
public class DriveWithJoysticks extends CommandBase {

    public DriveWithJoysticks() {
        requires(driveTrain);
    }
    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * Have the drivetrain drive tank drive with the latest values from joysticks.
     */
    protected void execute() {
        driveTrain.tankDrive(oi.getLeftSpeed(), oi.getRightSpeed());
    	//double m = (oi.getLeftSpeed() + oi.getRightSpeed())/2;
    	//double n = (oi.getLeftSpeed() - oi.getRightSpeed())/2;
    	//driveTrain.mecanum(oi.getRightX(), m, n);
    	
    	//driveTrain.mecanum(oi.getLeftX(), oi.getLeftSpeed(), oi.getRightX());
    	//driveTrain.mecanum(oi.getRightSpeed(), oi.getLeftSpeed(), oi.getRightX());
        if(oi.getRight4())
        {
        	//strafe left
        	driveTrain.strafe(.35, false);
        }
        if(oi.getRight5())
        {
        	//strafe right
        	driveTrain.strafe(.35, true);
        }
        if(oi.getLeft5())
        {
        	SmartDashboard.putString("DB/String 0", "Gyro: "+gyro.getAngle());
        }
        if(oi.getLeft8())
        {
        	gyro.reset();
        }
        	
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
        end();
    }

}
