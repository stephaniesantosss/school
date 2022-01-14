package com.br.school.application.student;

import com.br.school.domain.student.Student;
import com.br.school.domain.student.StudentRepository;

public class EnrollStudent {

    private final StudentRepository studentRepository;

    public EnrollStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void run(EnrollStudentDTO enrollStudentDTO){
        Student student = enrollStudentDTO.toConvert();
        studentRepository.enroll(student);
    }
}
