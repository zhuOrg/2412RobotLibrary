package com.robototes.drivebase;

import com.robototes.math.Vector;
import com.robototes.motors.PIDMotorController;
import com.robototes.units.Distance;
import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.Joystick;

public interface IDrivebase<T extends PIDMotorController<?>> {

	public void joystickDrive(Joystick stick);

	public void drive(double speed, double angle);

	public void stop();

	public void addDistanceDrive(Distance distance);

	public void useDistancePID();

	public Distance getTotalDistance();

	public void setSnapToAngle(Rotations rotation);

	public void addAngle(Rotations rotation);

	public void useAnglePID();

	public Rotations getHeading();

	public T[] getMotors();

	public void setVector(Vector path);

	public void setControlMode(ControlMode mode);

	public ControlMode getControlMode();

	public enum ControlMode {
		VECTOR, NONE, MANUAL, ROTATION, DISTANCE
	}
}
