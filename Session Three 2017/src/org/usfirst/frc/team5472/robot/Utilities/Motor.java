package org.usfirst.frc.team5472.robot.Utilities;

import edu.wpi.first.wpilibj.VictorSP;

public class Motor {
	
	private VictorSP speedController;
	
	public Motor(int pwm) {
		this.speedController = new VictorSP(pwm);
	}
	
	public void set(int speed) {
		speed = speed < -100 ? -100 : (speed > 100 ? 100 : speed);
		speedController.set(speed / 100.0);
	}
	
	public void stop() {
		set(0);
	}
	
	public void invert() {
		speedController.setInverted(!speedController.getInverted());
	}
}
