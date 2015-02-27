package org.usfirst.frc5107.commands;

import org.usfirst.frc5107.autocommands.driveForTime;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup{
	
	public Auto(){
		//addSequential(new driveForTime(0,0),5);
		//addSequential(new StraightDrive(0.0, 0.0, 5));
		//								lspeed,rspeed,timeout in seconds
		addSequential(new driveForTime(.3,.3,3));
	}
}
