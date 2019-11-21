package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.Command;

public class PIDAddCommand<T extends PIDMotorController<?>, K extends IUnit<K>> extends Command {
	PIDSubsystem<T, K> subsystem;
	K add;
	K initial;
	private double closeness;

	public PIDAddCommand(PIDSubsystem<T, K> subsystem, K unit, double closeness) {
		this.subsystem = subsystem;
		this.add = unit;
		this.closeness = closeness;
	}

	@Override
	protected void initialize() {
		initial = subsystem.getError();
		subsystem.setReference(add);
	}

	@Override
	public void execute() {
		subsystem.usePID();
	}

	@Override
	protected boolean isFinished() {
		return (subsystem.getError().subtract(initial.add(add)).getValue() < closeness);
	}
}
