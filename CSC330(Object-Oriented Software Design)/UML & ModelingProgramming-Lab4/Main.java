package edu.cuny.csi.csc330.lab4;

public class Main {

	public static void main(String[] args) {

		Car car = new Car();
		System.out.println("Initial State: ");
		System.out.println(car.toString());

// filling the information
		car.setBrand("Honda Pilot");
		car.setDestination("Newyork, Staten Island");
		car.setNumPassengers(3);
		System.out.println("\nAfter Loading passengers");
		System.out.println(car.toString());

//the car begins to move
		car.startdriving();
		car.setSpeed(25);
		System.out.println("\nAfter the car starts moving");
		System.out.println(car.toString());

//the car doesnt move
		car.carstoppedmoving();
		car.setSpeed(0);
		System.out.println("\nAfter the car stop moving");
		System.out.println(car.toString());

	}

}