package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class UsePIDAddCommand<T extends IUnit<T>> extends CommandGroup {

	public UsePIDAddCommand(PIDSubsystem<?, T> PIDSubsystem, T addPosition, double howCloseMustItBe) {
		addSequential(new PIDAddCommand<T>(PIDSubsystem, addPosition));
		addSequential(new UsePIDCommand<T>(PIDSubsystem, addPosition.add(PIDSubsystem.getError()), howCloseMustItBe));
	}
}
