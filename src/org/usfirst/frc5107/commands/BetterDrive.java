package org.usfirst.frc5107.commands;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANNotInitializedException;

public class BetterDrive extends RobotDrive{
	protected SpeedController m_frontLeftMotor;
    protected SpeedController m_frontRightMotor;
    protected SpeedController m_rearLeftMotor;
    protected SpeedController m_rearRightMotor;
    private boolean m_isCANInitialized = true;
	public BetterDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		bish();
	}
	private void bish(){
		m_frontLeftMotor = super.m_frontLeftMotor;
	    m_frontRightMotor = super.m_frontRightMotor;
	    m_rearLeftMotor = super.m_rearLeftMotor;
	    m_rearRightMotor = super.m_rearRightMotor;
	}
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
		double flOutput = -leftOutput;
		double frOutput = -rightOutput;
		double rlOutput = leftOutput;
		double rrOutput = rightOutput;
		
		if (m_rearLeftMotor == null || m_rearRightMotor == null) {
            throw new NullPointerException("Null motor provided");
        }

        byte syncGroup = (byte)0x80;

        if (m_frontLeftMotor != null) {
            m_frontLeftMotor.set(limit(flOutput) * m_invertedMotors[MotorType.kFrontLeft.value] * m_maxOutput, syncGroup);
        }
        m_rearLeftMotor.set(limit(rlOutput) * m_invertedMotors[MotorType.kRearLeft.value] * m_maxOutput, syncGroup);

        if (m_frontRightMotor != null) {
            m_frontRightMotor.set(-limit(frOutput) * m_invertedMotors[MotorType.kFrontRight.value] * m_maxOutput, syncGroup);
        }
        m_rearRightMotor.set(-limit(rrOutput) * m_invertedMotors[MotorType.kRearRight.value] * m_maxOutput, syncGroup);

        if (m_isCANInitialized) {
            try {
                CANJaguar.updateSyncGroup(syncGroup);
            } catch (CANNotInitializedException e) {
                m_isCANInitialized = false;
            }
        }

        if (m_safetyHelper != null) m_safetyHelper.feed();
	}
}
