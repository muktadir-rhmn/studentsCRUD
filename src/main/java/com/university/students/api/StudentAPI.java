package com.university.students.api;

import com.university.students.api.pojos.AddStudentRequest;
import com.university.students.api.pojos.GetStudentsResponse;
import com.university.students.api.pojos.UpdateStudentRequest;
import com.university.students.api.repos.StudentRepository;
import com.university.students.utils.pojos.SingleMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentAPI {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentAPI(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("")
	public GetStudentsResponse getStudents() {
		GetStudentsResponse response = new GetStudentsResponse();

		response.students = studentRepository.getStudents();

		return response;
	}

	@PostMapping("")
	public SingleMessageResponse addStudent(@RequestBody @Valid AddStudentRequest request) {
		studentRepository.Add(request.name);
		return SingleMessageResponse.OK;
	}

	@PutMapping("/{studentID}")
	public SingleMessageResponse updateStudent(
			@PathVariable Long studentID,
			@RequestBody @Valid UpdateStudentRequest request
	) {
		boolean hasUpdated = studentRepository.UpdateIfExists(studentID, request.name);

		if (hasUpdated) return SingleMessageResponse.OK;
		else return new SingleMessageResponse("Student with the given ID does not exists");
	}

	@DeleteMapping("/{studentID}")
	public SingleMessageResponse deleteStudent(
			@PathVariable Long studentID,
			@RequestBody @Valid UpdateStudentRequest request
	) {
		boolean hasDeleted = studentRepository.deleteIfExists(studentID);

		if (hasDeleted) return SingleMessageResponse.OK;
		else return new SingleMessageResponse("Student with the given ID does not exists");
	}
}
