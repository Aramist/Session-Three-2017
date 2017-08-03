package org.usfirst.frc.team5472.robot.individual;

import org.usfirst.frc.team5472.robot.CamperRobot;
import org.usfirst.frc.team5472.robot.Utilities.Joystick;
import org.usfirst.frc.team5472.robot.Utilities.Motor;
import org.usfirst.frc.team5472.robot.Utilities.Piston;

public class GroupTwo implements CamperRobot{
	/**
	 * This is the class for the robot with two pistons (one solenoid) holding the gear
	 */
	
	//PWM IDs for each motor
	private static int leftMotorID = 1;
	private static int rightMotorID = 2;
	
	//PCM IDs for each piston (this bot only has one)
	private static int pistonID = 0;
	
	/**The following lines of code handle the creation of the objects for each component (motors/solenoids)
	 * These objects provide an easy way to control the components through code
	 */
	private Motor leftMotor = new Motor(leftMotorID);
	private Motor rightMotor = new Motor(rightMotorID);
	
	private Piston piston = new Piston(pistonID);
	
	/**
	 * The object following this comment is the Joystick object
	 * it allows for the reading of josytick input
	 */
	private Joystick stick = new Joystick();
	
	/**
	 * The following boolean (a true or false value) is used to determine if the button
	 * has been pressed or released
	 */
	private boolean previousTriggerButtonState = false;
	
	/**
	 * Any code placed inside this method will be run when the robot is turned on (the battery is plugged in)
	 */
	@Override
	public void startup() {
		//nothing to do here
	}
	
	/**
	 * Any code placed inside this method will be run when the robot is enabled
	 */
	@Override
	public void whileEnabled() {
		/*
		 * The following code creates a speed for the left and right motors using the joystick's y axis and twist axis
		 */
		int joystickT = stick.twist();
		int joystickY = stick.yAxis();
		
		int left = joystickY + joystickT / 2;
		int right = joystickY - joystickT / 2;
		
		leftMotor.set(left);
		rightMotor.set(right);
		
		/*
		 * The following code toggles the end effector's piston using the trigger button (under the index finger)
		 */
		if(stick.getButton(Joystick.TRIGGER_BUTTON) != previousTriggerButtonState && previousTriggerButtonState == true) {
			piston.toggle();
			previousTriggerButtonState = !previousTriggerButtonState;
		}
	}

	/**
	 * Any code placed inside this method will be run when the robot is disabled
	 */
	@Override
	public void shutdown() {
		leftMotor.set(0);
		rightMotor.set(0);
		piston.deactivate();
	}

}
