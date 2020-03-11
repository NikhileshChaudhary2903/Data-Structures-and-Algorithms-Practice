package org.nik.javabrains;

import java.util.*;

public class Unit3Examples {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("Nikhil", "Chaudhary",27),
				new Person("Davinder", "Kumar",38),
				new Person("Shan", "Bains",14),
				new Person("Harsh", "Bains",10),
				new Person("Sanjna", "Bains",36)
				);
		
		persons.forEach((p) -> System.out.println(p));
		
		System.out.println("after sorting by firstname");
		
		Collections.sort(persons, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
		persons.forEach((p) -> System.out.println(p));
		
		persons.stream()
				.filter((p) -> p.getFirstName().startsWith("S"))
				.forEach((p) -> System.out.println(p));		
						

	}
}
