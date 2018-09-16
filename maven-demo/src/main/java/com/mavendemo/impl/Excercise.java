package com.mavendemo.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Excercise {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person("Pal", "Amit", 21), new Person("Sharma", "Anuj", 21),
				new Person("Kushwaha", "Ashish", 21), new Person("Panchal", "Ankit", 21),
				new Person("Tiwari", "Anand", 21));

		/*
		 * Collections.sort(persons, new Comparator<Person>() {
		 * 
		 * public int compare(Person o1, Person o2) { return
		 * o1.getLastName().compareTo(o2.getLastName()); } });
		 */

		Collections.sort(persons, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		for (Person p : persons) {
			System.out.println(p);
		}

		/*
		 * printConditionally(persons, new CheckName() {
		 * 
		 * @Override public boolean test(Person p) { return
		 * p.getLastName().startsWith("P"); } });
		 */

		printConditionally(persons, p -> p.getLastName().startsWith("P"));

		CheckName checkName = p -> p.getLastName().startsWith("P");

		Predicate<Person> predicate = p -> p.getLastName().startsWith("P");
		/*
		 * for (Person p : persons) { if (checkName.test(p)) {
		 * System.out.println(p); } }
		 */

		printConditionally(persons, predicate);

	}

	/*
	 * private static void printConditionally(List<Person> persons, CheckName
	 * checkName) { for (Person p : persons) { if (checkName.test(p)) {
	 * System.out.println(p); } } }
	 */

	private static void printConditionally(List<Person> persons, Predicate<Person> predicate) {
		for (Person p : persons) {
			if (predicate.test(p)) {
				System.out.println(p);
			}
		}
	}

}

interface CheckName {

	boolean test(Person p);
}