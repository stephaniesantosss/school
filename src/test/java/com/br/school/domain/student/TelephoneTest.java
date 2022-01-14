package com.br.school.domain.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class TelephoneTest {

    @Test
    public void shouldNotCreatePhoneWithInvalidDDD() {
        assertThrows(IllegalArgumentException.class, () -> new Telephone(null, "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("1", "123456789"));
    }

    @Test
    public void shouldNotCreatePhoneWithInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Telephone("11", null));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("11", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("11", "123"));
    }

    @Test
    public void youMustCreateAPhoneWithAValidAreaCodeAndNumber() {
        String ddd = "11";
        String number = "123456789";
        Telephone telephone = new Telephone(ddd, number);
        assertEquals(ddd, telephone.getDdd());
        assertEquals(number, telephone.getNumber());
    }
}