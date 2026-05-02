package com.userregistration;

public class UserRegistrationApp {

    public static void main(String[] args) {
        UserValidator validator = new UserValidator();

        System.out.println("First Name Valid: " + validator.isValidFirstName("Hari"));
        System.out.println("Last Name Valid: " + validator.isValidLastName("Karthick"));
        System.out.println("Email Valid: " + validator.isValidEmail("abc.xyz@bl.co.in"));
        System.out.println("Mobile Valid: " + validator.isValidMobile("91 9919819801"));
        System.out.println("Password Valid: " + validator.isValidPassword("Hari@123"));
    }
}