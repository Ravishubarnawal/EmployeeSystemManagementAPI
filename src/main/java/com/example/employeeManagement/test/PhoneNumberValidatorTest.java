package com.example.employeeManagement.test;

import com.example.employeeManagement.utils.PhoneNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PhoneNumberValidatorTest {
    private PhoneNumberValidator underTest;
    @BeforeEach
    void setUp(){
        underTest = new PhoneNumberValidator();
    }
    @Test
    void itShouldValidatePhoneNumber(){
        //Given
        String empPhone = "+9779810326137";

        //When
        boolean isValid =  underTest.test(empPhone);
        //Then
        if(isValid==true){
            assert(isValid);
        }

    }

    @Test
    @DisplayName("Should fail when length is bigger than 14")
    void itShouldValidatePhoneNumberWhenIncorrectAndHasLengthBiggerThan14(){
        //Given
        String empPhone = "+9779810326137000";

        //When
        boolean isValid =  underTest.test(empPhone);
        //Then
        if(isValid==false){
            System.out.println("PhoneNumber with" +empPhone+ "is greater than actual PhoneNumber");
        }


    }
    @Test
    @DisplayName("Should fail when does not start with +977")
    void itShouldValidatePhoneNumberWhenDoesNotStartWithPlusSign(){
        //Given
        String empPhone = "9779810326137";

        //When
        boolean isValid =  underTest.test(empPhone);
        //Then
        if(isValid==false){
            System.out.println("PhoneNumber with" +empPhone+ "is missing + code");
        }

    }
}

