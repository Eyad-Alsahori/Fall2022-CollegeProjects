package edu.cuny.csi.csc330.lab4;

import java.util.Date;

public class Car {
// Private instance variable
	private String carBrand;
	private String destination;
	private int Passengers;
	private double speed;
	private boolean startdrive;
	private Date GPSTime;
	private boolean carstoppedmoving;

	public Car() {

	}

	public String getcarBrand() {
		return carBrand;
	}

	public String getDestination() {
		return destination;
	}

	public int getPassengers() {
		return Passengers;
	}

	public double getSpeed() {
		return speed;
	}

	public boolean startdrive() {
		return startdrive;
	}

	public Date getGPSTime() {
		return GPSTime;
	}

	public boolean carstopped() {
		return carstoppedmoving;
	}

	public void setBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setNumPassengers(int Passengers) {
		this.Passengers = Passengers;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void startdriving() {
		if (!isdriving()) {
			this.startdrive = true;
			this.carstoppedmoving = false;
// Set time to drive
			this.GPSTime = new Date();
		}
	}

	public void carstoppedmoving() {
		if (isdriving()) {
			this.carstoppedmoving = true;
			this.startdrive = false;

		}
	}

	public boolean isdriving() {
// began driving but not did not stop moving
		return startdrive && !carstoppedmoving;
	}

	@Override
	public String toString() {
		return "Car [carBrand=" + carBrand + ", destination=" + destination + ", Passengers=" + Passengers + ", speed="
				+ speed + "mph \nstartdrive=" + startdrive + ", GPSTime=" + GPSTime + "\ncarstoppedmoving="
				+ carstoppedmoving + ", \nIs driving: " + isdriving() + ".";
	}

}