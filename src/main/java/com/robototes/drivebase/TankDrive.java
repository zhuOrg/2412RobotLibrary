package com.robototes.drivebase;

import com.robototes.PIDControls.PIDConstants;
import com.robototes.PIDControls.PIDController;
import com.robototes.control.DistanceSubsystem;
import com.robototes.control.JoystickUtils;
import com.robototes.math.MathUtils;
import com.robototes.math.Vector;
import com.robototes.motors.PIDMotorController;
import com.robototes.sensors.Gyro;
import com.robototes.units.Distance;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.Rotations;
import com.robototes.units.Time;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;
import com.robototes.units.UnitTypes.TimeUnits;
import com.robototes.utils.ArrayUtils;

import edu.wpi.first.wpilibj.Joystick;

public class TankDrive<T extends PIDMotorController<?>> implements IDrivebase<T> {

	DistanceSubsystem<T> left;
	DistanceSubsystem<T> right;
	T[] motors;
	// Gryo gryo;
	PIDController rotationPIDController;

	ControlMode mode;

	Rotations rotationSetPostition;
	Gyro gyro;

	public TankDrive(T[] leftMotors, T[] rightMotors,
			InterUnitRatio<RotationUnits, DistanceUnits> motorRotationsToDistanceDriven, PIDConstants rotationConstants,
			Gyro gyro) {
		left = new DistanceSubsystem<T>(leftMotors, motorRotationsToDistanceDriven);
		right = new DistanceSubsystem<T>(rightMotors, motorRotationsToDistanceDriven);

		motors = ArrayUtils.stackArrays(leftMotors, rightMotors);

		rotationPIDController = new PIDController(rotationConstants);

		this.gyro = gyro;

		mode = ControlMode.NONE;
	}

	@Override
	public void joystickDrive(Joystick stick) {
		setControlMode(ControlMode.MANUAL);

		double[] cubedInputs = JoystickUtils.cubeValues(stick);

		drive(cubedInputs[1], cubedInputs[2]);
	}

	@Override
	public void drive(double speed, double angle) {
		double leftMotorOutput;
		double rightMotorOutput;

		double maxInput = Math.copySign(Math.max(Math.abs(speed), Math.abs(angle)), speed);

		if (speed >= 0.0) {
			// First quadrant, else second quadrant
			if (angle >= 0.0) {
				leftMotorOutput = maxInput;
				rightMotorOutput = speed - angle;
			} else {
				leftMotorOutput = speed + angle;
				rightMotorOutput = maxInput;
			}
		} else {
			// Third quadrant, else fourth quadrant
			if (angle >= 0.0) {
				leftMotorOutput = speed + angle;
				rightMotorOutput = maxInput;
			} else {
				leftMotorOutput = maxInput;
				rightMotorOutput = speed - angle;
			}
		}

		leftMotorOutput = MathUtils.constrain(leftMotorOutput, -1, 1);
		rightMotorOutput = MathUtils.constrain(rightMotorOutput, -1, 1);

		left.setMotorSpeed(leftMotorOutput);
		right.setMotorSpeed(rightMotorOutput);
	}

	@Override
	public void stop() {
		setControlMode(ControlMode.NONE);

		for (T motor : motors) {
			motor.setSpeed(0);
		}
	}

	@Override
	public void addDistanceDrive(Distance distance) {
		if (mode != ControlMode.DISTANCE) {
			return;
		}

		left.addRefecence(distance);
		right.addRefecence(distance);
	}

	@Override
	public void setSnapToAngle(Rotations rotation) {
		if (mode != ControlMode.ROTATION) {
			return;
		}
		rotationSetPostition = rotation;
	}

	@Override
	public T[] getMotors() {
		return motors;
	}

	@Override
	public void setVector(Vector path) {
		if (mode != ControlMode.VECTOR) {
			return;
		}
		mode = ControlMode.DISTANCE;
		addDistanceDrive(new Distance(path.length));
		mode = ControlMode.ROTATION;
		addAngle(new Rotations(path.angle, RotationUnits.RADIAN));
	}

	@Override
	public void setControlMode(ControlMode mode) {
		if (this.mode == ControlMode.MANUAL) {
			if (mode == ControlMode.NONE) {
				this.mode = mode;
			}
		} else {
			this.mode = mode;
		}
	}

	@Override
	public ControlMode getControlMode() {
		return mode;
	}

	@Override
	public void useDistancePID() {
		if (this.mode != ControlMode.DISTANCE) {
			return;
		}
		left.usePID();
		right.usePID();
	}

	@Override
	public void useAnglePID() {
		if (this.mode == ControlMode.ROTATION) {
			return;
		}
		double input = rotationSetPostition.subtract(getHeading()).getValue();
		double output = rotationPIDController.getOutput(input, new Time(5, TimeUnits.MILLISECOND).getValue());

		for (T motor : motors) {
			motor.setSpeed(output);
		}
	}

	@Override
	public Distance getTotalDistance() {
		return left.getError().add(right.getError()).divide(new Distance(2));
	}

	@Override
	public Rotations getHeading() {
		return gyro.getRotations();
	}

	@Override
	public void addAngle(Rotations rotation) {
		if (mode != ControlMode.ROTATION) {
			return;
		}
		rotationSetPostition = rotationSetPostition.add(rotation);
	}

}