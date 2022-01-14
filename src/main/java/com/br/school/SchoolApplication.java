package com.br.school;

import com.br.school.application.student.EnrollStudent;
import com.br.school.application.student.EnrollStudentDTO;
import com.br.school.infrastructure.student.StudentRepositoryInMemory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		String name = "Stephanie Santos";
		String cpf = "123.456.789-00";
		String email = "stephanie@gmail.com";

		EnrollStudent enrollStudent = new EnrollStudent(new StudentRepositoryInMemory());
		enrollStudent.run(new EnrollStudentDTO(name, cpf, email));

		//SpringApplication.run(SchoolApplication.class, args);
	}

}
