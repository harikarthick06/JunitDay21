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

        System.out.println("\n===== UC3: Email Validation =====");
        System.out.println("Email 'abc@bl.co.in' Valid: " + validator.isValidEmail("abc@bl.co.in"));
        System.out.println("Email 'abc.xyz@bl.co.in' Valid: " + validator.isValidEmail("abc.xyz@bl.co.in"));
        System.out.println("Email 'abc+xyz@bl.co.in' Valid: " + validator.isValidEmail("abc+xyz@bl.co.in"));
        System.out.println("Email 'abc@bl' Valid: " + validator.isValidEmail("abc@bl"));

        try {
            validator.validateEmail("abc.xyz@bl.co.in");
            System.out.println("Validation for 'abc.xyz@bl.co.in' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        try {
            validator.validateEmail("abc@bl");
            System.out.println("Validation for 'abc@bl' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        System.out.println("\n===== UC4: Mobile Validation =====");
        System.out.println("Mobile '91 9919819801' Valid: " + validator.isValidMobile("91 9919819801"));
        System.out.println("Mobile '44 1234567890' Valid: " + validator.isValidMobile("44 1234567890"));
        System.out.println("Mobile '9919819801' Valid: " + validator.isValidMobile("9919819801"));

        try {
            validator.validateMobile("91 9919819801");
            System.out.println("Validation for '91 9919819801' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        try {
            validator.validateMobile("9919819801");
            System.out.println("Validation for '9919819801' passed!");
        } catch (InvalidUserDetailException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}