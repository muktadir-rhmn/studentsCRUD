package com.university.students.api.repos;

import com.university.students.api.pojos.Student;
import com.university.students.utils.Assertion;
import com.university.students.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public StudentRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void Add(String name) {
		String sql = "INSERT INTO students(name, m_time,  c_time) VALUES(?, ?, ?);";
		int nRows = jdbcTemplate.update(sql, name, Time.curUnixEpoch(), Time.curUnixEpoch());

		Assertion.assertEqual(nRows, 1);
	}

	public boolean UpdateIfExists(long id, String name) {
		String sql = "UPDATE students SET name = ?, m_time = ? WHERE id=?;";
		long curTime = Time.curUnixEpoch();
		return jdbcTemplate.update(sql, name, curTime, id) == 1;
	}

	public boolean deleteIfExists(long id) {
		String sql = "DELETE FROM students WHERE id=?;";
		return jdbcTemplate.update(sql, id) == 1;
	}

	public List<Student> getStudents() {
		String sql = "SELECT " +
				Student.getColumnNameList() +
				" FROM students;";
		return jdbcTemplate.query(sql, Student.getRowMapper());
	}
}
