package com.robototes.math;

import static java.lang.Math.atan2;

public class Vector {

	public double x;
	public double y;

	public double length;
	public double angle;

	public Vector() {
		this.x = 0;
		this.y = 0;
		this.length = 0;
		this.angle = 0;
	}

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;

		this.length = MathUtils.distance(x, y);
		this.angle = atan2(y, x);
	}

	public Vector(double angle) {
		this.angle = angle;
		this.length = 1;

		this.x = Math.cos(angle);
		this.y = Math.sin(angle);
	}

	public Vector add(double x, double y) {
		return new Vector(this.x + x, this.y + y);
	}

	public Vector add(Vector other) {
		return add(other.x, other.y);
	}

	public Vector sub(double x, double y) {
		return new Vector(this.x - x, this.y - y);
	}

	public Vector sub(Vector other) {
		return add(other.x, other.y);
	}

	public Vector divide(double scale) {
		this.x /= scale;
		this.y /= scale;
		this.length /= scale;
		return this;
	}

	public Vector multiply(double scale) {
		this.x *= scale;
		this.y *= scale;
		this.length *= scale;
		return this;
	}

	public double dot(Vector other) {
		return atan2(other.y, other.x) - atan2(this.y, this.x);
	}
}
