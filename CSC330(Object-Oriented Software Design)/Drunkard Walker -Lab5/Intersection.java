package edu.cuny.csi.csc330.lab5;

import java.util.Set;
import java.util.TreeSet;

public class Intersection implements Comparable<Intersection> {

	private int avenue;
	private int street;

	/*
	 * Why do we need this constructor? It's an easy way to copy the class instead
	 * of passing to bypass references.
	 */

	public Intersection(Intersection intersection) {
		this.avenue = intersection.getAvenue();
		this.street = intersection.getStreet();
	}

	public Intersection(int avenue, int street) {
		this.avenue = avenue;
		this.street = street;
	}

	public int getAvenue() {
		return avenue;
	}

	public void setAvenue(int avenue) {
		this.avenue = avenue;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
	}

	public String getMapKey() {
		return "ave=" + getAvenue() + "street=" + getStreet();
	}

	/**
	 * toString() method !!!!!!!!!!!!!!!!!
	 */

	@Override
	public String toString() {
		return "[Intersection ave= " + avenue + ", street=" + street + "]";
	}

	public void incStreet() {
		this.street++;
	}

	public void incAvenue() {
		this.avenue++;
	}

	public void decStreet() {
		this.street--;
	}

	public void decAvenue() {
		this.avenue--;
	}

	public void copyIntersection(Intersection otherI) {
		avenue = otherI.getAvenue();
		street = otherI.getStreet();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + avenue;
		result = prime * result + street;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intersection other = (Intersection) obj;
		if (avenue != other.avenue)
			return false;
		if (street != other.street)
			return false;
		return true;
	}

	public static void main(String[] args) {

		// create 2 instances , populate, display, compare ... does everything look
		// sane??
		Intersection Corner1 = new Intersection(6, 23);
		Intersection Corner2 = new Intersection(7, 41);

		System.out.println("Corner1" + Corner1);
		System.out.println("Corner2" + Corner2);

		System.out.println(Corner1.hashCode());
		System.out.println(Corner2.hashCode());

		if (Corner1.equals(Corner2))
			System.out.println("These Corners are equal.");

		else
			System.out.println("These Corners are not equal.");
	}

	Set<Intersection> set = new TreeSet<Intersection>();

	@Override
	public int compareTo(Intersection o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

