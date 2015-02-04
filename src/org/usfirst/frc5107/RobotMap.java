package org.usfirst.frc5107;

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
            liftMotor,
            lIntake,
            rIntake,
            lIntake2,
            rIntake2;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static int
            clawUp,
            clawDown;
    
    public static double
            liftMotorSpeed,
            intakeSpeed;
    public RobotMap()
    { 
    	Preferences pref = Preferences.getInstance();
        //Motors
    	fLeftMotor = pref.getInt("fLeftMotor", 0);
        rLeftMotor = pref.getInt("rLeftMotor", 1);
        fRightMotor = pref.getInt("fRightMotor", 2);
        rRightMotor = pref.getInt("rRightMotor", 3);
        liftMotor = pref.getInt("liftMotor", 5);
        lIntake = pref.getInt("lIntake", 6);
        rIntake = pref.getInt("rIntake", 7);
        lIntake2 = pref.getInt("lIntake2", 8);
        rIntake2 = pref.getInt("rIntake2", 9);
        //Limit Switches
        clawUp  = pref.getInt("clawUp", 1);
        clawDown = pref.getInt("clawDown", 2);
        //Motor Speeds
        liftMotorSpeed = pref.getInt("liftMotorSpeed", 1);
        intakeSpeed = pref.getInt("intakeSpeed", 1);

        
    }
 }

            
