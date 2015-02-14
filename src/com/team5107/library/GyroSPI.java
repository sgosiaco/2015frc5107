package com.team5107.library;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import java.util.ArrayList;

public class GyroSPI {
	private static final byte FIRST_BYTE_DATA = 0x3;
	private static final byte THIRD_BYTE_DATA = (byte)(0xFC);
	private static final byte READ_COMMAND = 0x20;
	private static final byte PARITY_BIT = 1;
	
	private static final byte DATA_SIZE = 4;
	
	private SPI spi;
	
	double WARM_UP_PERIOD = 5.0;  //seconds
	double CALIBRATE_PERIOD = 15.0; //seconds
	
	private byte[] command;
	private byte[] data;
	
	private int iLoop;
	
	private Timer calibration_timer;
	private Timer update_timer;
	
	private double accumulated_angle;
	private double current_rate;
	private double accumulated_offset;
	private double rate_offset;
	private double lastTime;
	private double thisTime;
	
	public GyroSPI(SPI.Port port){
		iLoop = 0;
		
		spi = new SPI(port);
		spi.setClockRate(4000000); //4 MHz (rRIO max, gyro can go high)
		spi.setClockActiveHigh();
		spi.setChipSelectActiveLow();
		spi.setMSBFirst();
		
		command = new byte[4];
		command[0] = READ_COMMAND;
		command[1] = 0;
		command[2] = 0;
		command[3] = 0;
		data = new byte[4];
		data[0] = 0;
		data[1] = 0;
		data[2] = 0;
		data[3] = 0;
		
		accumulated_angle = 0.0;
		current_rate = 0.0;
		accumulated_offset = 0.0;
		rate_offset = 0.0;
		
		calibration_timer = new Timer();
		calibration_timer.start();
		update_timer = new Timer();
		update_timer.start();
		Update();
	}
	public double getRate(){
		return current_rate;
	}
	public double getAngle(){
		return accumulated_angle;
	}
	public double Offset(){
		return rate_offset;
	}
	public void Update(){
		check_parity(command);
		spi.transaction(command, data, DATA_SIZE); //perform transaction, get error code

		if (calibration_timer.get() < WARM_UP_PERIOD){
			thisTime = lastTime = update_timer.get();
		} else if (calibration_timer.get() < CALIBRATE_PERIOD) {
			Calibrate();
		} else {
			UpdateData();
		}
	}
	public void reset(){
		data[0] = 0;
		data[1] = 0;
		data[2] = 0;
		data[3] = 0;
		current_rate = 0.0;
		accumulated_angle = 0.0;
		rate_offset = 0.0;
		accumulated_offset = 0.0;

		//calibration_timer.stop();
		calibration_timer.reset();

		//update_timer.stop();
		update_timer.reset();
	}
	private void UpdateData() {
		int sensor_data = assemble_sensor_data(data);
		double rate = (sensor_data) / 80;
		current_rate = rate;
		current_rate -= rate_offset;
		thisTime = update_timer.get();
		double time_diff = thisTime - lastTime;
		accumulated_offset += rate * time_diff;
		accumulated_angle  +=  current_rate * time_diff;
		lastTime = thisTime;
	}
	private void Calibrate() {
		int sensor_data = assemble_sensor_data(data);
		double rate = (sensor_data) / 80.0;
		iLoop++;
		thisTime = update_timer.get();
		accumulated_offset += (rate * (thisTime - lastTime));
		lastTime = thisTime;
		rate_offset = accumulated_offset / (iLoop);
	}
	private short assemble_sensor_data(byte[] data){
		//cast to short to make space for shifts
		//the 16 bits from the gyro are a 2's complement short
		//so we just cast it too a C++ short
		//the data is split across the output like this (MSB first): (D = data bit, X = not data)
		// X X X X X X D D | D D D D D D D D | D D D D D D X X | X X X X X X X X X
		return (short) (((data[0] & FIRST_BYTE_DATA)) << 14	|
				(data[1]) << 6 | ((data[2] & THIRD_BYTE_DATA)) >> 2);
	}

	private void check_parity(byte[] command) {
		int num_bits = bits(command[0]) + bits(command[1]) + bits(command[2]) + bits(command[3]);

		if (num_bits % 2 == 0) {
			command[3] |= PARITY_BIT;
		}
	}

	private int bits(byte val) {
		int n = 0;

		while (val > 0) {
			val &= val-1;
			n += 1;
		}

		return n;
	}
}
