package com.university.students.api.pojos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateStudentRequest {
	@NotBlank(message = "Name must not be empty")
	@Size(max = 50, message = "Name must not be longer than 50 characters")
	public String name;
}
