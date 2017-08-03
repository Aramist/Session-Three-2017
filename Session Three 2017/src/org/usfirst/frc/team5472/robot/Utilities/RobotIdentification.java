package org.usfirst.frc.team5472.robot.Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RobotIdentification {
	
	private static String filePath = "/home/lvuser/id.txt";
	
	private int robotID;
	
	public RobotIdentification() {
		FileReader reader;
		try {
			reader = new FileReader(filePath);
			char[] buffer = new char[1];
			reader.read(buffer, 0, 1);
			reader.close();
			try {
				robotID = Integer.parseInt(new String(buffer));
			} catch (Exception e) {
				robotID = 0;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Identification file not found, using ID 0");
			robotID = 0;
		} catch (IOException e) {
			e.printStackTrace();
			robotID = 0;
		}
		System.out.printf("This robot's ID is %i", robotID);
	}
	
	public int getRobotID() {
		return robotID;
	}
}
