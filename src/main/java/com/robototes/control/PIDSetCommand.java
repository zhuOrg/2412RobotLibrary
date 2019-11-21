package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.Command;

public class PIDSetCommand<T extends PIDMotorController<?>, K extends IUnit<K>> extends Command {
	PIDSubsystem<T, K> subsystem;
	K set;
	private double closeness;

	public PIDSetCommand(PIDSubsystem<T, K> subsystem, K unit, double closeness) {
		this.subsystem = subsystem;
		this.set = unit;
		this.closeness = closeness;
	}

	@Override
	protected void initialize() {
		subsystem.setReference(set);
	}

	@Override
	public void execute() {
		subsystem.usePID();
	}

	@Override
	protected boolean isFinished() {
		return (subsystem.getError().subtract(set).getValue() < closeness);
	}
}
