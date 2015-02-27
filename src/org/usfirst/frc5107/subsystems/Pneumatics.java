/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc5107.subsystems;


import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc5107.commands.ClawClose;

/**
 *
 * @author BITKRUSHER
 */
public class Pneumatics extends Subsystem {

    //Solenoid solenoid0;
    //Solenoid solenoid1;
    Solenoid solenoid2;
    Solenoid solenoid3;

    
    public Pneumatics() {
    	//solenoid0 = new Solenoid(0);
    	//solenoid1 = new Solenoid(1);
        solenoid2 = new Solenoid(2);
        solenoid3 = new Solenoid(3);

    }

    public void initDefaultCommand() {
        //setDefaultCommand(new ClawClose());
    }

    public void liftOn()
    {
    	//solenoid0.set(true); 
    	//solenoid1.set(true);
    	solenoid2.set(true);
    	solenoid3.set(true);
    }
    public void liftOff()
    {
    	//solenoid0.set(false); 
    	//solenoid1.set(false);
    	solenoid2.set(false);
    	solenoid3.set(false);
    }

    public void leftOn()
    {
    	solenoid3.set(true);
    }
    public void rightOn()
    {
    	solenoid2.set(true);
    }
    public void leftOff()
    {
        solenoid3.set(false);	
    }
    public void rightOff()
    {
        solenoid2.set(false);
    }
}
