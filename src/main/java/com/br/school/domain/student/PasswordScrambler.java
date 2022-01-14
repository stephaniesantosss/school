package com.br.school.domain.student;

public interface PasswordScrambler {

    String encryptPassword(String password);
    boolean validateEncryptedPassword(String encryptPassword, String password);

}
