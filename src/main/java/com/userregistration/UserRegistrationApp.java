package com.userregistration;

public class UserRegistrationApp {

    public static void main(String[] args) {
        UserValidator validator = new UserValidator();

        System.out.println("===== UC1: First Name Validation =====");
        System.out.println("First Name 'Hari' Valid: " + validator.isValidFirstName("Hari"));
        System.out.println("First Name 'hari' Valid: " + validator.isValidFirstName("hari"));
        System.out.println("First Name 'Ha' Valid: " + validator.isValidFirstName("Ha"));

        try {
            validator.validateFirstName("Hari");
            System.out.println("Validation for 'Hari' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        try {
            validator.validateFirstName("hari");
            System.out.println("Validation for 'hari' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}