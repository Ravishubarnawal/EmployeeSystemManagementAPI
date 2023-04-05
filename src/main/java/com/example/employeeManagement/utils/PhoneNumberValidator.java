package com.example.employeeManagement.utils;

import javax.enterprise.inject.Default;
import javax.ws.rs.ext.Provider;
import java.util.function.Predicate;
@Provider
public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String empPhone) {
        if((empPhone.startsWith("+977")) && (empPhone.length()==14)){
            return true;
        }
        return false;
    }
}
