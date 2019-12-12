package com.robototes.drivebase;

import com.robototes.math.Vector;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MultiVectorDrive extends CommandGroup {
	public <T extends IDrivebase<?>> MultiVectorDrive(T drivebase, Vector[] vects, double deadband) {
		for (Vector vect : vects) {
			addSequential(new VectorDrive(drivebase, vect, deadband));
		}
	}
}
