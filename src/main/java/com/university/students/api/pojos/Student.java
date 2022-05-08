package com.university.students.api.pojos;

import org.springframework.jdbc.core.RowMapper;

public class Student {
	public long id;
	public String name;
	public long mTime;
	public long cTime;

	public static String getColumnNameList() {
		return " id, name, m_time, c_time ";
	}

	private static RowMapper<Student> rowMapper = (resultSet, iRow) -> {
		Student student = new Student();

		student.id = resultSet.getLong("id");
		student.name = resultSet.getString("name");
		student.cTime = resultSet.getLong("c_time");
		student.mTime = resultSet.getLong("m_time");

		return student;
	};

	public static RowMapper<Student> getRowMapper() {
		return rowMapper;
	}
}
