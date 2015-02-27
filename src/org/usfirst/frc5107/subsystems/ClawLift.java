/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc5107.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc5107.RobotMap;

/**
 *
 * @author BITKRUSHER
 */
public class ClawLift extends Subsystem {
    //Lift Motor
    Victor liftMotor;
    
    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public ClawLift() {
    	liftMotor = new Victor(RobotMap.liftMotor);
    }
    
    /**
     * Initialize the default command to be {@link ClawDoNothing}.
     */
    public void initDefaultCommand() {
        //setDefaultCommand(new ClawDoNothing());
    }
    public void clawUp(){
            liftMotor.set(1);	  
    }
    public void clawDown(){
            liftMotor.set(-.5);
    }
    public void clawMOff(){
            liftMotor.set(0);
    }
}
