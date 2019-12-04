package com.robototes.drivebase;

import com.robototes.drivebase.IDrivebase.ControlMode;
import com.robototes.units.Rotations;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SnapToAngle extends CommandGroup {
	public <T extends IDrivebase<?>> SnapToAngle(T drivebase, Rotations rotations, double deadband) {
		drivebase.setControlMode(ControlMode.ROTATION);
		addSequential(new SetRotationDrive<T>(drivebase, rotations));
		addSequential(new UseRotationDrive<T>(drivebase, rotations, deadband));
	}
}
