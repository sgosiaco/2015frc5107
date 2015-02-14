/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc5107.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5107.RobotMap;

/**
 *
 * @author BITKRUSHER
 */
public class Claw extends Subsystem {
    //Lift Motor
    Victor liftMotor;
    //Limit switches for up and down positions
    DigitalInput clawUpLimit;
    DigitalInput clawDownLimit;
    
    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public Claw() {
    	liftMotor = new Victor(RobotMap.liftMotor);
    	//clawUpLimit = new DigitalInput(RobotMap.clawUp);
        //clawDownLimit = new DigitalInput(RobotMap.clawDown);
        
    }
    
    /**
     * Initialize the default command to be {@link ClawDoNothing}.
     */
    public void initDefaultCommand() {
        //setDefaultCommand(new ClawDoNothing());
    }
    public void clawUp(){
            liftMotor.set(.6);	  
    }
    public void clawDown(){
            liftMotor.set(-.2);
    }
    public void clawOff(){
           liftMotor.set(0);
    }
    public boolean clawUpLimit(){
        return clawUpLimit.get();
    }
    public boolean clawDownLimit(){
    	return clawDownLimit.get();
    }
}
