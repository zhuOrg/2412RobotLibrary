package com.robototes.sensors;

import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.RotationUnits;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI.Port;

public class Gyro extends ADXRS450_Gyro {

	public Gyro() {
		super();
	}

	public Gyro(Port port) {
		super(port);
	}

	public Rotations getRotations() {
		return new Rotations(this.getAngle() % 360, RotationUnits.DEGREE);
	}
}
