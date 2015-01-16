package org.usfirst.frc5107.commands;

import org.usfirst.frc5107.autocommands.driveForTime;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto extends CommandGroup{
	
	public Auto(){
		addSequential(new driveForTime(0,0),5);
	}
}
