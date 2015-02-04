package org.usfirst.frc5107.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Encoders extends Subsystem{
	/**
	public Encoder flWheel; // Front left
	public Encoder frWheel; // Front Right
	public Encoder rlWheel; // Rear Left
	public Encoder rrWheel; // Rear Right
	private DigitalInput a1;
	private DigitalInput b1;
	private DigitalInput a2;
	private DigitalInput b2;
	private DigitalInput a3;
	private DigitalInput b3;
	private DigitalInput a4;
	private DigitalInput b4;
	*/
	@Override
	protected void initDefaultCommand() {
		
	}
	public Encoders(){
		/**
		// First 2 numbers are digital input ports
		// False means dont invert the counting direction
		a1 = new DigitalInput(0);
		b1 = new DigitalInput(1);
		a2 = new DigitalInput(2);
		b2 = new DigitalInput(3);
		a3 = new DigitalInput(4);
		b3 = new DigitalInput(5);
		a4 = new DigitalInput(6);
		b4 = new DigitalInput(7);
		//TODO  test if integers work with java update
		flWheel = new Encoder(a1,b1,false, Encoder.EncodingType.k4X);
		frWheel = new Encoder(a2,b2,false, Encoder.EncodingType.k4X);
		rlWheel = new Encoder(a3,b3,false, Encoder.EncodingType.k4X);
		rrWheel = new Encoder(a4,b4,false, Encoder.EncodingType.k4X);
		*/
	}
	
	public void reset(){
		/**
		flWheel.reset();
		frWheel.reset();
		rlWheel.reset();
		rrWheel.reset();
		*/
	}

}
