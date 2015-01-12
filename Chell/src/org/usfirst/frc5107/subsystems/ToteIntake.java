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
    Victor lIntake2;
    Victor rIntake2;
    
    // Initialize your subsystem here
    /**
     * Initialize the claw with the motor declared in {@link RobotMap}
     */
    public ToteIntake() {
        lIntake = new Victor(RobotMap.lIntake);
        rIntake = new Victor(RobotMap.rIntake);
        lIntake2 = new Victor(RobotMap.lIntake2);
        rIntake2 = new Victor(RobotMap.rIntake2);
        
    }
    
    /**
     * Initialize the default command to be {@link ClawDoNothing}.
     */
    public void initDefaultCommand() {
        //setDefaultCommand();
    }
    public void outIntakeForward(){
        lIntake.set(RobotMap.intakeSpeed);
        rIntake.set(RobotMap.intakeSpeed);
    }
    public void outIntakeReverse(){
    	lIntake.set(-RobotMap.intakeSpeed);
    	rIntake.set(-RobotMap.intakeSpeed);
    }
    public void outIntakeOff(){
        lIntake.set(0);
        rIntake.set(0);
    }

    public void inIntakeForward(){
    	lIntake2.set(RobotMap.intakeSpeed);
    	rIntake2.set(RobotMap.intakeSpeed);
    }
    public void inIntakeReverse(){
    	lIntake2.set(-RobotMap.intakeSpeed);
    	rIntake2.set(-RobotMap.intakeSpeed);
    }
    public void inIntakeOff(){
        lIntake2.set(0);
        rIntake2.set(0);
    }
}
