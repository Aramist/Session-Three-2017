package org.usfirst.frc.team5472.robot.Utilities;

import edu.wpi.first.wpilibj.AnalogInput;

public class PressureSensor {
	
	private AnalogInput aIn;
	
	public PressureSensor() {
		this(0);
	}
	
	public PressureSensor(int analogPort) {
		this.aIn = new AnalogInput(analogPort);
	}
	
	public double getPressure() {
		return (250 * aIn.getVoltage() / 4.95) - 24.0;
	}
}
