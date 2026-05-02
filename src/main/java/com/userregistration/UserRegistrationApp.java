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

        System.out.println("\n===== UC2: Last Name Validation =====");
        System.out.println("Last Name 'Karthick' Valid: " + validator.isValidLastName("Karthick"));
        System.out.println("Last Name 'karthick' Valid: " + validator.isValidLastName("karthick"));
        System.out.println("Last Name 'Ka' Valid: " + validator.isValidLastName("Ka"));

        try {
            validator.validateLastName("Karthick");
            System.out.println("Validation for 'Karthick' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        try {
            validator.validateLastName("karthick");
            System.out.println("Validation for 'karthick' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}