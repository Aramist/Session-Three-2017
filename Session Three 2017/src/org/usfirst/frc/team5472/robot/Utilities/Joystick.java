package org.usfirst.frc.team5472.robot.Utilities;

public class Joystick {
	
	public static int TRIGGER_BUTTON = 1;
	public static int THUMB_BUTTON = 2;
	
	private edu.wpi.first.wpilibj.Joystick stick;
	
	public Joystick() {
		this(0);
	}
	
	public Joystick(int stickID) {
		this.stick = new edu.wpi.first.wpilibj.Joystick(stickID);
	}
	
	public int xAxis() {
		return (int)(stick.getX() * 100);
	}
	
	public int yAxis() {
		return (int)(stick.getY() * 100);
	}
	
	public int twist() { 
		return (int)(stick.getTwist() * 100);
	}
	
	public boolean getButton(int button) {
		return stick.getRawButton(button);
	}
}
