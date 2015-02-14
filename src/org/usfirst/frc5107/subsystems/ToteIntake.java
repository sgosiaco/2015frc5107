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
public class ToteIntake extends Subsystem {
        // The claws motor
    Victor lIntake;
    Victor rIntake;
    
    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public ToteIntake() {
        lIntake = new Victor(RobotMap.lIntake);
        rIntake = new Victor(RobotMap.rIntake);
        
    }
    
    /**
     * Initialize the default command to be {@link ClawDoNothing}.
     */
    public void initDefaultCommand() {
        //setDefaultCommand();
    }
    public void IntakeForward(){
        lIntake.set(RobotMap.intakeSpeed);
        rIntake.set(-RobotMap.intakeSpeed);
    }
    public void IntakeReverse(){
    	lIntake.set(-RobotMap.intakeSpeed);
    	rIntake.set(+RobotMap.intakeSpeed);
    }
    public void IntakeOff(){
        lIntake.set(0);
        rIntake.set(0);
    }
}
