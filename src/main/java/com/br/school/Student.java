package com.br.school;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;
    private List<Telephone> telephones = new ArrayList<>();

    public void addPhone(String ddd, String number){
        this.telephones.add(new Telephone(ddd, number));
    }


}
