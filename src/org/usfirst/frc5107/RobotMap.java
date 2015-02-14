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
            rIntake;
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
    	fLeftMotor = pref.getInt("fLeftMotor", 4);
        rLeftMotor = pref.getInt("rLeftMotor", 3);
        fRightMotor = pref.getInt("fRightMotor", 2);
        rRightMotor = pref.getInt("rRightMotor", 1);
        liftMotor = pref.getInt("liftMotor", 2);
        lIntake = pref.getInt("lIntake", 0);
        rIntake = pref.getInt("rIntake", 1);
        //Limit Switches
        clawUp  = pref.getInt("clawUp", 1);
        clawDown = pref.getInt("clawDown", 2);
        //Motor Speeds
        liftMotorSpeed = pref.getDouble("liftMotorSpeed", .5);
        intakeSpeed = pref.getDouble("intakeSpeed", .5);
        liftMotorSpeed = pref.getDouble("liftMotorSpeed", .4);
        intakeSpeed = pref.getDouble("intakeSpeed", .4);

        
    }
 }

            
