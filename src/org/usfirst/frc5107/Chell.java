/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             
*/
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5107;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;

import org.usfirst.frc5107.commands.Auto;
//import org.usfirst.frc5107.commands.AutonomousCommand;
import org.usfirst.frc5107.commands.CommandBase;
import org.usfirst.frc5107.commands.GyroUpdate;
import org.usfirst.frc5107.RobotMap;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Chell extends IterativeRobot {

    Command autonomousCommand;
    CameraServer server;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("God damn");
    	RobotMap map = new RobotMap();
    	CommandBase.init();
    	Command gupdate = new GyroUpdate();
    	Scheduler.getInstance().add(gupdate);
        //server = CameraServer.getInstance();
        //server.setQuality(20);
        //server.startAutomaticCapture("cam1");
        
        // instantiate the command used for the autonomous period
        
    	//autonomousCommand = new Auto();
        

        // Initialize all subsystems
        Compressor comp = new Compressor();
        comp.clearAllPCMStickyFaults();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        
    	//autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        
    	//autonomousCommand.cancel(); 
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
