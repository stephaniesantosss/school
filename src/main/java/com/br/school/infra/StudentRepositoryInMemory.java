package com.br.school.infra;

import com.br.school.domain.student.CPF;
import com.br.school.domain.student.Student;
import com.br.school.domain.student.StudentNotFound;
import com.br.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> enrolled = new ArrayList<>();

    @Override
    public void enroll(Student student) {
        this.enrolled.add(student);
    }

    @Override
    public Student searchByCPF(CPF cpf) {
        return this.enrolled.stream().filter(a -> a.getCpf().equals(cpf.getNumber()))
                .findFirst().orElseThrow(() -> new StudentNotFound(cpf));
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return this.enrolled;
    }
}
