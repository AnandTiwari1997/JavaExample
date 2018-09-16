package com.mavendemo.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FinalSolutionUsingJava8 {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Pal", "Amit", 21),
				new Person("Sharma", "Anuj", 21),
				new Person("Kushwaha", "Ashish", 21),
				new Person("Panchal", "Ankit", 21),
				new Person("Tiwari", "Anand", 21)
			);

		Collections.sort(persons, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		printConditionally(persons, p -> true, p -> System.out.println(p));

		printConditionally(persons, p -> p.getLastName().startsWith("P"), p -> System.out.println(p.getLastName()));

	}
	
	private static void printConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p : persons) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
}
