package com.br.school.application.student;

import com.br.school.domain.student.CPF;
import com.br.school.domain.student.Email;
import com.br.school.domain.student.Student;

public class EnrollStudentDTO {

    private String name;
    private String cpf;
    private String email;

    public EnrollStudentDTO(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Student toConvert(){
        return new Student(new CPF(cpf), name, new Email(email));
    }
}
