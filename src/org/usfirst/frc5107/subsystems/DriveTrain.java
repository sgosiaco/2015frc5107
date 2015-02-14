/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc5107.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc5107.RobotMap;
import org.usfirst.frc5107.commands.CommandBase;
import org.usfirst.frc5107.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.VictorSP;
/**
 *
 * @author BITKRUSHER
 */
public class DriveTrain extends Subsystem {
    RobotDrive drive;
    CANTalon fLtalon = new CANTalon(4);
    CANTalon rLtalon = new CANTalon(3);
    CANTalon fRtalon = new CANTalon(2);
    CANTalon rRtalon = new CANTalon(1);
    CANTalon[] talons = new CANTalon[4];
    //VictorSP frontLeft = new VictorSP(0);
    //VictorSP frontRight = new VictorSP(1);
    //VictorSP rearLeft = new VictorSP(2);
    //VictorSP rearRight = new VictorSP(3);
    public DriveTrain(){
       talons[0] = fLtalon;
       talons[1] = rLtalon;
       talons[2] = fRtalon;
       talons[3] = rRtalon;
    	System.out.println("DriveTrain Active");
       //drive = new RobotDrive(RobotMap.fLeftMotor, RobotMap.rLeftMotor, RobotMap.fRightMotor, RobotMap.rRightMotor);
       //drive = new RobotDrive(frontLeft, frontRight, rearLeft, rearRight);
       drive = new RobotDrive(fLtalon, rLtalon, fRtalon, rRtalon);
       drive.setSafetyEnabled(false);
       //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
       //drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
       //drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
       //drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
       drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
       drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
       drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
       drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
       //rRtalon.changeControlMode(CANTalon.ControlMode.Speed);
       //rRtalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
       //rRtalon.setPosition(0);
       //rRtalon.set(1);
       for(int i = 0; i < 4; i++)
       {
    	   //talons[i].changeControlMode(CANTalon.ControlMode.Speed);
    	   //talons[i].setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
    	   talons[i].setPosition(0);
    	   talons[i].setProfile(0);
    	   
       }

 }
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }
    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);
    }

    public void valDrive(double magnitude, double curve) {
        drive.drive(magnitude, curve);
    }
    public void mecanum(double x, double y, double rotation)
    {
    	drive.mecanumDrive_Cartesian(x, y, rotation, 0);
    }
    public void strafe(double speed, boolean strafe)
    {
    	if(strafe == true)
    	{
    		//left strafe
        	//turn towards each other on left and away from each other on right
    		
    	    //drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	    //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
    		fLtalon.set(speed);
    		rLtalon.set(-speed);
    		fRtalon.set(-speed);
    		rRtalon.set(speed);
    		//drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
    	    //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        }
    	else
    	{
    		//right strafe
        	//away from each other on left and turn towards each other on right
    		
    		//drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
    		//drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    		fLtalon.set(-speed);
    		rLtalon.set(speed);
    		fRtalon.set(speed);
    		rRtalon.set(-speed);
    		//drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    		//drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    	}
    }
}
