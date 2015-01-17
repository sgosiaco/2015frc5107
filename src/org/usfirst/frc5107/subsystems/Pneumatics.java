/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc5107.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author BITKRUSHER
 */
public class Pneumatics extends Subsystem {

    Solenoid solenoid1;
    Solenoid solenoid2;
    
    public Pneumatics() {
        solenoid1 = new Solenoid(1);
        solenoid2 = new Solenoid(2);
    }

    public void initDefaultCommand() {
        //setDefaultCommand(new Compressor1());
    }

    public void liftOn()
    {
         solenoid1.set(true);
    }
    public void liftOff()
    {
         solenoid1.set(false);
    }
    public void clawOn()
    {
    	solenoid2.set(true);
    }
    public void clawOff()
    {
    	solenoid2.set(false);
    }
}
