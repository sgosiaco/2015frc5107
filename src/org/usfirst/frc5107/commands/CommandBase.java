package org.usfirst.frc5107.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.NamedSendable;

import org.usfirst.frc5107.OI;
import org.usfirst.frc5107.subsystems.Camera;
import org.usfirst.frc5107.subsystems.Claw;
import org.usfirst.frc5107.subsystems.ClawLift;
import org.usfirst.frc5107.subsystems.DriveTrain;
import org.usfirst.frc5107.subsystems.Encoders;
import org.usfirst.frc5107.subsystems.Gyroscope;
import org.usfirst.frc5107.subsystems.Pneumatics;
import org.usfirst.frc5107.subsystems.Camera;
import org.usfirst.frc5107.subsystems.ToteIntake;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static DriveTrain driveTrain = new DriveTrain();
    public static Claw claw = new Claw();
    public static Pneumatics pneumatics = new Pneumatics();
    //public static Camera camera = new Camera();
    public static ToteIntake toteIntake = new ToteIntake();
    //public static Encoders encoders = new Encoders();
    public static Gyroscope gyro = new Gyroscope();
    public static ClawLift clawLift = new ClawLift();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
    	System.out.println("Is it OI?");
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(claw);
        SmartDashboard.putData(pneumatics);
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
