package org.usfirst.frc.team5472.robot;

import org.usfirst.frc.team5472.robot.Utilities.PressureSensor;
import org.usfirst.frc.team5472.robot.Utilities.RobotIdentification;
import org.usfirst.frc.team5472.robot.individual.GroupOne;
import org.usfirst.frc.team5472.robot.individual.GroupTwo;
import org.usfirst.frc.team5472.robot.individual.GroupZero;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.SampleRobot;

public class Robot extends SampleRobot {
	
	private static Compressor comp;
	private static PressureSensor pressure;
	private static double pressureLimit;

	private RobotIdentification ID; 
	private CamperRobot program;
	
	@Override
	public void robotInit() {
		ID = new RobotIdentification();
		switch(ID.getRobotID()) {
		case 0:
			program = new GroupZero();
			break;
		case 1:
			program = new GroupOne();
			break;
		case 2:
			program = new GroupTwo();
			break;
		default:
			program = new GroupZero();
		}
		System.out.println(ID.getRobotID());
		program = new GroupZero();
		program.startup();
	}

	@Override
	public void operatorControl() {
		
		while(this.isEnabled()) {
			checkPressure();
			program.whileEnabled();
		}
		
		program.shutdown();
	}

	@Override
	public void test() {}

	@Override
	public void autonomous() {}

	public static void enforcePressureLimit(double psi) {
		if(comp == null && pressure == null) {
			comp = new Compressor();
			pressure = new PressureSensor();
			pressureLimit = psi;
		}
		
		checkPressure();
	}
	
	private static void checkPressure() {
		if(comp == null || pressure == null)
			return;
		if(pressure.getPressure() > pressureLimit && comp.enabled())
			comp.stop();
		else if(pressure.getPressure() < (pressureLimit - 5.0) && !comp.enabled())
			comp.start();
	}
}
