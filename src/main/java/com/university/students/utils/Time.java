package com.university.students.utils;

public final class Time {
	public static long curUnixEpoch() {
		return System.currentTimeMillis() / 1000;
	}
}

