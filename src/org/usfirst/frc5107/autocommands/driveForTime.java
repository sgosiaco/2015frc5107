package org.usfirst.frc5107.autocommands;

import org.usfirst.frc5107.commands.CommandBase;

public class driveForTime extends CommandBase{

	private double magnitude;
	private double curve;
	public driveForTime(double magnitude, double curve){
		this.magnitude = magnitude;
		this.curve = curve;
		requires(driveTrain);
	}
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected void execute() {
		driveTrain.valDrive(magnitude, curve);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
