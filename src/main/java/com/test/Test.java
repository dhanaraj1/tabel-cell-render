/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

/**
 *
 * @author Administrator
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// A class to represent a student.
class Student {
	int rollno;
	String name, address;

	// Constructor
	public Student(int rollno, String name, String address) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	// Used to print student details in main()
	@Override
	public String toString() {
		return this.rollno + " " + this.name + " " + this.address;
	}
}

class Sortbyname implements Comparator<Student> {
	// Used for sorting in ascending order of
	// roll name
	String nameB;

	@Override
	public int compare(Student a, Student b) {
		System.out.println("-----------------------------------------------------------------");

		if (a.name != null && b.name != null) {
			nameB=b.name;
			return a.name.compareTo(b.name) ;
		} else if(a.name == null && b.name == null)  {

			return 0;
		} else if (a.name==null && b.name !=null) {
			nameB=b.name;
			return 0;
		}else if (a.name!=null && b.name ==null) {
			if (nameB==null)
			{
				return 0;
			}

			return a.name.compareTo(nameB);
		}


		return 0;
	}
}

class Main {
	public static void main(String[] args) {
		final ArrayList<Student> ar = new ArrayList<>();
		ar.add(new Student(2, null, null));
		ar.add(new Student(1, "bbbb", "london"));

		ar.add(new Student(3, "dddd", "jaipur"));
		ar.add(new Student(4, null, null));

		ar.add(new Student(5, "eeee", "jaipur"));
		ar.add(new Student(6, "cccc", "jaipur"));
		ar.add(new Student(4, null, null));

		System.out.println("Unsorted");
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
		System.out.println("\n");

		Collections.sort(ar, new Sortbyname());

		System.out.println("\nSorted by name");
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
	}

}