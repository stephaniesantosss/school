package com.br.school.infrastructure.student;

import com.br.school.domain.student.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try {
            String sql = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumber());

            ResultSet rs = ps.executeQuery();
            boolean itFound = rs.next();
            if (!itFound) {
                throw new StudentNotFound(cpf);
            }

            String name = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Student studentFound = new Student(cpf, name, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, number FROM TELEPHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                studentFound.addPhone(ddd, number);
            }
            return studentFound;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> listAllEnrolledStudents() {
        String sql = "SELECT id, cpf, name, email FROM STUDENT";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<>();

            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String name = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Student student = new Student(cpf, name, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, number FROM TELEPHONE WHERE student_id = ?";
                PreparedStatement psTelephone = connection.prepareStatement(sql);
                psTelephone.setLong(1, id);
                ResultSet rsTelephone = psTelephone.executeQuery();

                while (rsTelephone.next()) {
                    String number = rsTelephone.getString("number");
                    String ddd = rsTelephone.getString("ddd");
                    student.addPhone(ddd, number);
                }
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
