package org.usfirst.frc5107.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Encoders extends Subsystem{

	public Encoder flWheel; // Front left
	public Encoder frWheel; // Front Right
	public Encoder rlWheel; // Rear Left
	public Encoder rrWheel; // Rear Right
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public Encoders(){
		// First 2 numbers are digital input ports
		// False means dont invert the counting direction
		flWheel = new Encoder(0,1,false, Encoder.EncodingType.k4X);
		frWheel = new Encoder(2,3,false, Encoder.EncodingType.k4X);
		rlWheel = new Encoder(4,5,false, Encoder.EncodingType.k4X);
		rrWheel = new Encoder(6,7,false, Encoder.EncodingType.k4X);
	}
	
	public void reset(){
		flWheel.reset();
		frWheel.reset();
		rlWheel.reset();
		rrWheel.reset();
	}

}
