package org.usfirst.frc5107.subsystems;

import com.team5107.library.GyroSPI;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyroscope extends Subsystem{
	private GyroSPI gyro;
	
	public Gyroscope(){
		gyro = new GyroSPI(SPI.Port.kOnboardCS0);
	}
	public void update(){
		gyro.Update();
	}
	public double getAngle(){
		return gyro.getAngle();
	}
	
	public double getRate(){
		return gyro.getRate();
	}
	
	public double getOffset(){
		return gyro.Offset();
	}
	
	public void reset(){
		gyro.reset();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
