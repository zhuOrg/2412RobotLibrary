package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class UsePIDSetCommand<T extends IUnit<T>> extends CommandGroup {

	public UsePIDSetCommand(PIDSubsystem<?, T> PIDSubsystem, T setPosition, double howCloseMustItBe) {
		addSequential(new PIDSetCommand<T>(PIDSubsystem, setPosition));
		addSequential(new UsePIDCommand<T>(PIDSubsystem, setPosition, howCloseMustItBe));
	}
}
