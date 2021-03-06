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
public class Claw extends Subsystem {
    //Lift Motor
    //Victor liftMotor;
    //Limit switches for up and down positions
    DigitalInput clawUpLimit;
    DigitalInput clawDownLimit;
    Solenoid solenoid4;
    Solenoid solenoid5;
    
    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public Claw() {
    	System.out.println("Claw Active");
    	//clawUpLimit = new DigitalInput(RobotMap.clawUp);
        //clawDownLimit = new DigitalInput(RobotMap.clawDown);
        solenoid4 = new Solenoid(4);
        solenoid5 = new Solenoid(5);
    }
    
    /**
     * Initialize the default command to be {@link ClawDoNothing}.
     */
    public void initDefaultCommand() {
        //setDefaultCommand(new ClawDoNothing());
    }
    public boolean clawUpLimit(){
        return clawUpLimit.get();
    }
    public boolean clawDownLimit(){
    	return clawDownLimit.get();
    }
    public void clawOn()
    {
    	solenoid4.set(true);
    	solenoid5.set(false);
    }
    public void clawOff()
    {
    	solenoid4.set(false);
    	solenoid5.set(true);
    }
}
