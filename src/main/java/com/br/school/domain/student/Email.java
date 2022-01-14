package com.br.school.domain.student;

public class Email {
    //Value Object

    private String address;

    public Email(String address) {

        //email validation regular expression
        if (address == null || !address.matches(("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
