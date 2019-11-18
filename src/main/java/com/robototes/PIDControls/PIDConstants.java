package com.robototes.PIDControls;

public class PIDConstants {
	public double k_P = 0;
	public double k_I = 0;
	public double k_D = 0;
	public double k_IDamp = 0;
	
	public PIDConstants(double k_P) {
		this.k_P = k_P;
	}

	public PIDConstants(double k_P, double k_I, double k_D, double k_IDamp) {
		this.k_P = k_P;
		this.k_I = k_I;
		this.k_D = k_D;
		this.k_IDamp = k_IDamp;
	}

	public PIDConstants(double k_P, double k_I, double k_D) {
		this.k_P = k_P;
		this.k_I = k_I;
		this.k_D = k_D;
	}

	public PIDConstants(double k_P, double k_D) {
		this.k_P = k_P;
		this.k_D = k_D;
	}

	public double getK_P() {
		return k_P;
	}

	public void setK_P(double k_P) {
		this.k_P = k_P;
	}

	public double getK_I() {
		return k_I;
	}

	public void setK_I(double k_I) {
		this.k_I = k_I;
	}

	public double getK_D() {
		return k_D;
	}

	public void setK_D(double k_D) {
		this.k_D = k_D;
	}

	public double getK_IDamp() {
		return k_IDamp;
	}

	public void setK_IDamp(double k_IDamp) {
		this.k_IDamp = k_IDamp;
	}
	
	
}
