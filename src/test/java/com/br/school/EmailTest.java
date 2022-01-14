package com.br.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmailTest {

    @Test
    public void shouldNotCreateEmailWithInvalidAddress(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email(""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Email("invalid-email"));
    }

}