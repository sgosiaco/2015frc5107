package org.usfirst.frc5107;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Preferences;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

	public static int
            fLeftMotor,
            rLeftMotor,
            fRightMotor,
            rRightMotor,
            //cMotor1 = 1,
            cMotor2,
            //cameraPan = 5,
            //cameraTilt = 6,
            cFeed,
            cScrew1,
            cScrew2,
            //solenoid1 = 3,
            solenoid2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static int
            clawLimit,
            screwUp,
            screwDown;
    
    public static double
            cMotorSpeed,
            cFeedSpeed,
            cScrewSpeed;
    public RobotMap()
    { 
    	Preferences pref = Preferences.getInstance();
        fLeftMotor = pref.getInt("fLeftMotor", 9);
        rLeftMotor = pref.getInt("rLeftMotor", 10);
        fRightMotor = pref.getInt("fRightMotor", 8);
        rRightMotor = pref.getInt("rRightMotor", 7);
        //cMotor1 = 1,
        cMotor2 = pref.getInt("cMotor2", 2);
        //cameraPan = 5,
        //cameraTilt = 6,
        cFeed = pref.getInt("cFeed", 6);
        cScrew1 = pref.getInt("cScrew1", 4);
        cScrew2 = pref.getInt("cScrew2", 5);
        //solenoid1 = 3,
        solenoid2 = pref.getInt("solenoid2", 3);
        clawLimit = pref.getInt("clawLimit", 2);
        screwUp = pref.getInt("screwUp", 3);
        screwDown = pref.getInt("screwDown", 4);
        cMotorSpeed = pref.getDouble("cMotorSpeed", -.75);
        cFeedSpeed = pref.getDouble("cFeedSpeed", .75);
        cScrewSpeed = pref.getDouble("cScrewSpeed", .25);
        
    }
 }

            
