package edu.cuny.csi.csc330.lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DrunkWalker {

	private Intersection startIntersection;
	private Intersection currentIntersection;

	private Map<String, ArrayList<Intersection>> intersectionVisits = new HashMap<>();

	public DrunkWalker(int avenue, int street) {
		startIntersection = new Intersection(avenue, street);
		currentIntersection = new Intersection(avenue, street);
	}

	public void step() {
		takeAStep();
		addCurrentStepToHistory();
	}

	private void takeAStep() {
		Direction direc = Direction.NONE.getNextRandom();

		int currentAvenue = currentIntersection.getAvenue();
		int currentStreet = currentIntersection.getStreet();

		switch (direc) {

		case EAST:
			currentIntersection.setStreet(currentStreet + 1);
			break;
		case WEST:
			currentIntersection.setStreet(currentStreet - 1);
			break;
		case NORTH:
			currentIntersection.setAvenue(currentAvenue + 1);
			break;
		case SOUTH:
			currentIntersection.setAvenue(currentAvenue - 1);
			break;
		case SOUTHEAST:
			currentIntersection.setAvenue(currentAvenue + 1);
			break;

		case SOUTHWEST:
			currentIntersection.setAvenue(currentAvenue - 1);
			break;
		case NORTHEAST:
			currentIntersection.setAvenue(currentAvenue + 1);
			break;

		case NORTHWEST:
			currentIntersection.setAvenue(currentAvenue - 1);
			break;
		}
	}

	public String getLocation() {
		return this.toString();
	}

	public void fastForward(int steps) {
		for (int i = 0; i < steps; i++)
			step();
	}

	public List<Intersection> getAllUniqueVisits() {
		return intersectionVisits.keySet().stream()
				.filter(intersection -> intersectionVisits.get(intersection).size() == 1)
				.map(intersectionString -> intersectionVisits.get(intersectionString).get(0))
				.collect(Collectors.toList());
	}

	public List<Intersection> getAllNonUniqueVisits() {
		return intersectionVisits.keySet().stream()
				.filter(intersection -> intersectionVisits.get(intersection).size() > 1)
				.map(intersectionString -> intersectionVisits.get(intersectionString).get(0))
				.collect(Collectors.toList());
	}

	public void displayWalkDetails() {
		System.out.println("Starting Location:  " + startIntersection);
		System.out.println("Current/Ending Location: " + currentIntersection);
		System.out.println("Number of steps taken: " + howFar());
		System.out.println("Unique Intersection Count: " + getAllUniqueVisits().size());
		System.out.println("Intersections Visited More Than Once: " + getAllNonUniqueVisits().size());
	}

	public int howFar() {
		int x1 = startIntersection.getAvenue();
		int y1 = startIntersection.getStreet();

		int x2 = currentIntersection.getAvenue();
		int y2 = currentIntersection.getStreet();

		return (Math.abs(x1 - x2)) + (Math.abs(y1 - y2));
	}

	private void addCurrentStepToHistory() {

		Intersection copiedIntersection = new Intersection(currentIntersection);
		if (intersectionVisits.containsKey(currentIntersection.getMapKey())) {
			ArrayList<Intersection> listOfLocations = intersectionVisits.get(currentIntersection.getMapKey());
			listOfLocations.add(copiedIntersection);
			intersectionVisits.put(currentIntersection.getMapKey(), listOfLocations);
		}

		else {
			ArrayList<Intersection> newList = new ArrayList<>();
			newList.add(copiedIntersection);
			intersectionVisits.put(currentIntersection.getMapKey(), newList);
		}
	}

	@Override
	public String toString() {
		return "[DrunkWalker] Current Intersection: " + currentIntersection + " Starting Position: "
				+ startIntersection;
	}

	public Map<String, ArrayList<Intersection>> getIntersectionVisits() {
		return intersectionVisits;
	}

	public static void main(String[] args) {

		DrunkWalker billy = new DrunkWalker(6, 23);

		for (int i = 1; i <= 3; ++i) {
			billy.step();
		}

		// get his current location
		String location = billy.getLocation();
		// get distance from start
		int distance = billy.howFar();
		System.out.println("Current location after fastForward(): " + location);
		System.out.println("That's " + distance + " blocks from start.");

		billy.fastForward(5);
		billy.displayWalkDetails();

		System.out.println();
		for (String key : billy.getIntersectionVisits().keySet()) {
			System.out.println("visited intersection: " + billy.getIntersectionVisits().get(key));
		}

		System.out.println("Unique Visits: ");
		System.out.println(billy.getAllUniqueVisits());

		System.out.println("Non-Unique Visits: ");
		System.out.println(billy.getAllNonUniqueVisits());
	}

}
