package com.br.school.domain.recommendation;

import com.br.school.domain.student.Student;

import java.time.LocalDateTime;

public class Recommendation {

    private Student indicated;
    private Student indicator;
    private LocalDateTime indicatedDate;

    public Recommendation(Student indicated, Student indicator) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.indicatedDate = LocalDateTime.now();
    }

    public Student getIndicated() {
        return indicated;
    }

    public Student getIndicator() {
        return indicator;
    }

    public LocalDateTime getIndicatedDate() {
        return indicatedDate;
    }
}
