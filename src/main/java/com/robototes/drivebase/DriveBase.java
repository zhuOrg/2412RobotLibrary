package com.robototes.drivebase;

import com.robototes.units.Distance;
import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.Joystick;

public interface DriveBase {
	
	public void joystickDrive(Joystick stick);

	public void drive(double speed, double angle, Rotations turn);
	
	public void stop();
	
	public void distanceDrive(Distance distance, double speed, double angle);	
	
	public void timeDrive(long time, double speed, double angle, Rotations turn);	

}
