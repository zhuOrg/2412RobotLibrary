package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.IUnit;

/**
 * An interface all PID Subsystems will use so things go smoothly
 * 
 * @author Eli Orona
 *
 * @param <T> Motors used in the subsystem
 * @param <K> Unit type of the subsystem
 */
public interface PIDSubsystem<T extends PIDMotorController<?>, K extends IUnit<K>> {

	/**
	 * Add to the reference of the subsystem
	 * 
	 * @param addRefernce Value of the reference to add
	 */
	public void addRefecence(K addRefernce);

	/**
	 * Gets the total error from the starting position
	 * 
	 * @return A value representing the error
	 */
	public K getError();

	/**
	 * Gets an array of the motors used
	 * 
	 * @return The motors used
	 */
	public T[] getMotors();

	/**
	 * Sets the speed of all of the motors
	 * 
	 * @param speed Speed for the motors
	 */
	public void setMotorSpeed(double speed);

	/**
	 * Set the refernce of the subsystem
	 * 
	 * @param reference Value of the reference
	 */
	public void setReference(K reference);

	/**
	 * Uses the PID, allowing for things to be set, then used at a certain time
	 */
	public void usePID();
}
