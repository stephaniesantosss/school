package com.br.school.domain.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CPFTest {

    @Test
    public void shouldNotCreateCpfWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("123456"));
    }

    @Test
    public void mustAllowCreatingCPFWithInvalidNumber(){
        String number = "123.456.789-00";
        CPF cpf = new CPF(number);
        assertEquals(number, cpf.getNumber());
    }

}