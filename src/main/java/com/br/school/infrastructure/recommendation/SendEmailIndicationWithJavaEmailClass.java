package com.br.school.infrastructure.recommendation;

import com.br.school.application.recommendation.SendApplicationEmail;
import com.br.school.domain.student.Student;

public class SendEmailIndicationWithJavaEmailClass implements SendApplicationEmail {
    @Override
    public void sendTo(Student indicated) {
        //implementar
    }
}
