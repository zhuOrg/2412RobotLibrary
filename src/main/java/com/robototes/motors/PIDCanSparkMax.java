package com.robototes.motors;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.robototes.PIDControls.PIDConstants;
import com.robototes.PIDControls.PIDController;
import com.robototes.motors.MotorRotations.SparkMaxRotations;
import com.robototes.units.Rotations;
import com.robototes.units.Time;
import com.robototes.units.UnitTypes.TimeUnits;

/**
 * A wrapper class for CANSparkMax by Revrobotics. Allows for PID Control of the
 * motor
 * 
 * @author Eli Orona
 *
 */
public class PIDCanSparkMax extends CANSparkMax implements PIDMotorController<SparkMaxRotations> {

	private CANEncoder encoder;
	private PIDController controller;
	private SparkMaxRotations setPoint = new SparkMaxRotations(0);

	public PIDCanSparkMax(int deviceID, MotorType type, PIDConstants constants) {
		super(deviceID, type);
		this.encoder = this.getEncoder();
		this.controller = new PIDController(constants);
		this.controller.setMinMax(-0.5, 0.5);
	}

	@Override
	public void addRotations(Rotations rotations) {
		this.addRotations(new SparkMaxRotations(rotations));
	}

	@Override
	public void addRotations(SparkMaxRotations rotations) {
		this.setPoint = (SparkMaxRotations) this.setPoint.add(rotations);
	}

	@Override
	public SparkMaxRotations getRotations() {
		SparkMaxRotations rots = new SparkMaxRotations(encoder.getPosition());
		return rots;
	}

	@Override
	public void setRotations(Rotations rotations) {
		this.setRotations(new SparkMaxRotations(rotations));
	}

	@Override
	public void setRotations(SparkMaxRotations rotations) {
		this.setPoint = rotations;
	}

	@Override
	public void setSpeed(double speed) {
		this.set(speed);
	}

	@Override
	public double usePIDOutput() {
		return usePIDOutput(new Time(5, TimeUnits.MILLISECOND)); // loop time of robot
	}

	@Override
	public double usePIDOutput(Time timestep) {
		double output = controller.getOutput(setPoint.subtract(getRotations()).getValue(), timestep.getValue());
		this.set(output);
		return output;
	}

}
