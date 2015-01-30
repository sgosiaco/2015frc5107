package org.usfirst.frc5107.commands;

public class StraightDrive extends CommandBase{
	private double lspeed;
	private double rspeed;
	private double timeout;
	public StraightDrive(double initLSpeed, double initRSpeed, double seconds){
		lspeed = initLSpeed;
		rspeed = initRSpeed;
		timeout = seconds;
		requires(driveTrain);
	}
	
	@Override
	protected void initialize() {
		setTimeout(timeout);
	}

	@Override
	protected void execute() {
		while(true){
			double left = encoders.flWheel.getRate();
			double right = encoders.frWheel.getRate();
			double num = left-right;
			
			if(num > 10 ){ // replace 10 with a reasonable threshold
				if(left > right){
					driveTrain.tankDrive(lspeed, rspeed+.01);
				}
				else{
					driveTrain.tankDrive(lspeed+.01, rspeed);
				}
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		driveTrain.valDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
