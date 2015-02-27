package org.usfirst.frc5107.autocommands;

import org.usfirst.frc5107.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

public class driveForTime extends CommandBase{

	private double magL;
	private double magR;
	private double tlimit;
	private Timer timer;
	public driveForTime(double magnitudeL, double magnitudeR, double time){
		this.magL = magnitudeL;
		this.magR = magnitudeR;
		tlimit = time;
		timer = new Timer();
		requires(driveTrain);
	}
	@Override
	protected void initialize() {
		timer.start();
	}
	
	@Override
	protected void execute() {
		driveTrain.tankDrive(magL, magR);
	}

	@Override
	protected boolean isFinished() {
		if(timer.get() >= tlimit){
			return true;
		}else{
			return false;
		}
	}

	@Override
	protected void end() {
		timer.stop();
		driveTrain.tankDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
