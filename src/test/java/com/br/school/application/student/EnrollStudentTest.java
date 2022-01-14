package com.br.school.application.student;

import com.br.school.domain.student.CPF;
import com.br.school.domain.student.Student;
import com.br.school.infrastructure.student.StudentRepositoryInMemory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EnrollStudentTest {

    @Test
    void mustPersistStudent() {
        StudentRepositoryInMemory studentRepository = new StudentRepositoryInMemory();
        EnrollStudent enrollStudent = new EnrollStudent(studentRepository);

        EnrollStudentDTO dados = new EnrollStudentDTO("Stephanie Santos", "123.456.789-00", "stephanie@gmail.com");
        enrollStudent.run(dados);

        Student studentFound = studentRepository.searchByCPF(new CPF("123.456.789-00"));
        assertEquals("Stephanie Santos", studentFound.getName());
        assertEquals("123.456.789-00", studentFound.getCpf());
        assertEquals("stephanie@gmail.com", studentFound.getEmail());
    }

}
