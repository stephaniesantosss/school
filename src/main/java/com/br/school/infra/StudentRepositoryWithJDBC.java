package com.br.school.infra;

import com.br.school.domain.student.CPF;
import com.br.school.domain.student.Student;
import com.br.school.domain.student.StudentRepository;
import com.br.school.domain.student.Telephone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryWithJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryWithJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void enroll(Student student) {
        String sql = "INSEERT INTO STUDENT VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEPHONE VALUES(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telephone telephones : student.getTelephones()) {
                ps.setString(1, telephones.getDdd());
                ps.setString(2, telephones.getNumber());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student searchByCPF(CPF cpf) {
        return null;
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        return null;
    }
}
