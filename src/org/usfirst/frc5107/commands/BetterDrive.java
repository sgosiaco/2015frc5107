package org.usfirst.frc5107.commands;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class BetterDrive extends RobotDrive{
	public BetterDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		
	}
	@Override
	public void tankDrive(double leftOutput, double rightOutput){
		leftOutput = limit(leftOutput);
		rightOutput = limit(rightOutput);
        if (leftOutput >= 0.0) {
        	leftOutput = (leftOutput * leftOutput);
        } else {
        	leftOutput = -(leftOutput * leftOutput);
        }
        if (rightOutput >= 0.0) {
        	rightOutput = (rightOutput * rightOutput);
        } else {
        	rightOutput = -(rightOutput * rightOutput);
        }
		
        if (m_rearLeftMotor == null || m_rearRightMotor == null) {
            throw new NullPointerException("Null motor provided");
        }

        if (m_frontLeftMotor != null) {
            m_frontLeftMotor.set(-leftOutput * m_invertedMotors[0] * m_maxOutput, m_syncGroup);
        }
        m_rearLeftMotor.set(leftOutput * m_invertedMotors[2] * m_maxOutput, m_syncGroup);

        if (m_frontRightMotor != null) {
            m_frontRightMotor.set(rightOutput * m_invertedMotors[1] * m_maxOutput, m_syncGroup);
        }
        m_rearRightMotor.set(-rightOutput * m_invertedMotors[3] * m_maxOutput, m_syncGroup);

        if (this.m_syncGroup != 0) {
            CANJaguar.updateSyncGroup(m_syncGroup);
        }

        if (m_safetyHelper != null) m_safetyHelper.feed();
	}
}
