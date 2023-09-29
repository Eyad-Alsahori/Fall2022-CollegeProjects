package edu.cuny.csi.csc330.lab5;

import java.util.*;
import java.util.Scanner;

public class DrunkWalkTester {

	private Scanner input;

	public DrunkWalkTester() {
		init();
	}

	private void init() {
		input = new Scanner(System.in);
	}

	public void runTest(int steps) {

		System.out.print("Enter the starting avenue value: ");
		int avenue = input.nextInt();
		System.out.print("Enter the starting street value: ");
		int street = input.nextInt();

		//////////////////////// start test
		// make the Drunkard with initial position
		DrunkWalker billy = new DrunkWalker(avenue, street);

		// have him move/step 200 time
		billy.fastForward(steps);

		// get his current location
		String location = billy.getLocation();

		// get distance from start
		int distance = billy.howFar();

		System.out.println("Billy's " + location);
		System.out.println("That's " + distance + " blocks from start.");

		billy.displayWalkDetails();

		//////////////////// end test
		// ???

		DrunkWalker harvey = new DrunkWalker(avenue, street);

		System.out.println("\n Race Information:-");

		System.out.println("harvey:");
		System.out.println(harvey.getLocation());
		System.out.println("\n billy:");
		System.out.println(billy.getLocation());
		billy.displayWalkDetails();

		if (harvey.howFar() > billy.howFar()) {
			System.out.println("\n Hence: THE WINNER IS Harvey WITH " + harvey.howFar() + " steps!!!");
		} else if (billy.howFar() > harvey.howFar()) {
			System.out.println("\n Hence: THE WINNER IS Billy WITH " + billy.howFar() + " steps!!!");

		}

	}

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		DrunkWalkTester tester = new DrunkWalkTester();

		int steps = 2000;
		if (args.length == 1) {
			steps = Integer.parseInt(args[0]);
		}

		tester.runTest(steps);

		System.exit(0);

	}

}