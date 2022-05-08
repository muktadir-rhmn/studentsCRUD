package com.university.students.utils;

import com.university.students.error.exceptions.AssertionFailedException;

public class Assertion {
	public static void assertEqual(int n1, int n2) {
		if (n1 != n2) throw AssertionFailedException.EMPTY;
	}

	public static void assertNotNull(Object obj) {
		if (obj == null) throw AssertionFailedException.EMPTY;
	}
}
