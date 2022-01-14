package com.br.school;

public class CPF {

    private String number;

    public CPF(String number) {
        //cpf validation regular expression
        if (number == null || !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
