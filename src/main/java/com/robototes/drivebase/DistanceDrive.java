package com.robototes.drivebase;

import com.robototes.drivebase.IDrivebase.ControlMode;
import com.robototes.units.Distance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DistanceDrive extends CommandGroup {
	public <T extends IDrivebase<?>> DistanceDrive(T drivebase, Distance distance, double deadband) {
		drivebase.setControlMode(ControlMode.DISTANCE);
		addSequential(new AddDistanceDrive<T>(drivebase, distance));
		addSequential(new UseDistanceDrive<T>(drivebase, distance, deadband));
	}
}
