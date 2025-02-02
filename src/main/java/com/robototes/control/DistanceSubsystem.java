package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.Distance;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;

/**
 * A subsystem with PID control for distance
 * 
 * @author Eli Orona
 *
 * @param <T> Motors used
 */
public class DistanceSubsystem<T extends PIDMotorController<?>> implements PIDSubsystem<T, Distance> {

	private T[] motors;
	private InterUnitRatio<RotationUnits, DistanceUnits> rotationsToDistance;
	private Distance currentReference = new Distance(0);

	public DistanceSubsystem(T[] motors, InterUnitRatio<UnitTypes.RotationUnits, UnitTypes.DistanceUnits> ratio) {
		this.motors = motors;
		this.rotationsToDistance = ratio;
	}

	@Override
	public void addRefecence(Distance addRefernce) {
		currentReference = currentReference.add(addRefernce);
		Rotations rotationReference = new Rotations(rotationsToDistance.calculateReverseRatio(currentReference));
		for (T motor : motors) {
			motor.setRotations(rotationReference);
		}
	}

	@Override
	public Distance getError() {
		Distance totalDistance = new Distance(0);
		for (T motor : motors) {
			Distance motorDistance = new Distance(rotationsToDistance.calculateReverseRatio(motor.getRotations()));
			totalDistance = totalDistance.add(motorDistance);
		}
		totalDistance = totalDistance.divide(new Distance(motors.length));
		return totalDistance.subtract(currentReference);
	}

	@Override
	public T[] getMotors() {
		return motors;
	}

	@Override
	public void setMotorSpeed(double speed) {
		for (T motor : motors) {
			motor.setSpeed(speed);
		}
	}

	@Override
	public void setReference(Distance reference) {
		currentReference = reference;
		Rotations rotationReference = new Rotations(rotationsToDistance.calculateReverseRatio(reference));
		for (T motor : motors) {
			motor.setRotations(rotationReference);
		}
	}

	@Override
	public void usePID() {
		for (T motor : motors) {
			motor.usePIDOutput();
		}
	}
}
