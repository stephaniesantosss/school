package com.br.school.infra;

import com.br.school.domain.student.PasswordScrambler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encryptPasswordWithMD5 implements PasswordScrambler {

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(i));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating password hash");
        }
    }

    @Override
    public boolean validateEncryptedPassword(String encryptedPassword, String password) {
        return encryptedPassword.equals(encryptPassword(password));
    }
}
