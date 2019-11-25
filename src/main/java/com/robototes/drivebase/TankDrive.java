package com.robototes.drivebase;

import com.robototes.motors.PIDCanSparkMax;
import com.robototes.units.Distance;
import com.robototes.units.Rotations;
import com.robototes.units.UnitRatio;

import edu.wpi.first.wpilibj.Joystick;

public class TankDrive implements DriveBase{

	@Override
	public void drive(double speed, double turn, Rotations DONOTUSE) {
		for(int i = 0; i < lMotors.length; i++) {
			lMotors[i].set(speed-(turn*2));
			rMotors[i].set(-speed+(turn*2));

		}
		
	}
	
	@Override
	public void joystickDrive(Joystick stick) {
		drive(stick.getY(), stick.getTwist(), null);		
	}
	
	@Override
	public void stop() {
		drive(0, 0, null);
	}

	@Override
	public void distanceDrive(Distance distance, double speed, double angle) {
		while(rotationsToDistance.calculateRatio(lMotors[0].getRotations()) > distance.distance) {
			drive(speed, angle, null);
		}
	}

	@Override
	public void timeDrive(long time, double speed, double angle, Rotations turn) {
		long startTime = System.currentTimeMillis();
		while((System.currentTimeMillis()-startTime) < time) {
			drive(speed, angle, null);
		}
		
	}

	private boolean isFieldCentric;
	
	private Rotations gyro;
	
	private PIDCanSparkMax[] lMotors;
	
	private PIDCanSparkMax[] rMotors;
	
	private UnitRatio rotationsToDistance;
	
	public TankDrive(boolean ifc, PIDCanSparkMax[] leftMotors, PIDCanSparkMax[] rightMotors, Rotations gyroVal, UnitRatio rotToDist) {
		isFieldCentric = ifc;
		lMotors = leftMotors;
		rMotors = rightMotors;
		gyro = gyroVal;
		rotationsToDistance = rotToDist;
	}


	
}