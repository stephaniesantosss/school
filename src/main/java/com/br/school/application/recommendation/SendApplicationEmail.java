package com.br.school.application.recommendation;

import com.br.school.domain.student.Student;

public interface SendApplicationEmail {

    void sendTo(Student indicated);
}
