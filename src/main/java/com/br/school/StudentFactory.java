package com.br.school;

public class StudentFactory {

    private Student student;

    public StudentFactory createStudent(String cpf, String name, String email) {
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public StudentFactory createPhone(String ddd, String number) {
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student create() {
        return this.student;
    }
}
