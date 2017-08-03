package org.usfirst.frc.team5472.robot.Utilities;

import edu.wpi.first.wpilibj.Solenoid;

public class Piston {
	
	private Solenoid solenoid;
	
	public Piston(int pcmID) {
		this.solenoid = new Solenoid(pcmID);
	}
	
	public void activate() {
		if(!solenoid.get()) solenoid.set(true);
	}
	
	public void deactivate() {
		if(solenoid.get()) solenoid.set(false);
	}
	
	public void toggle() {
		solenoid.set(!solenoid.get());
	}
	
}
