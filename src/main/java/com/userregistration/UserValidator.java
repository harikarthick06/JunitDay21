package com.userregistration;

import java.util.regex.Pattern;

public class UserValidator {

    private static final String NAME_REGEX = "^[A-Z][a-zA-Z]{2,}$";

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}(\\.[a-zA-Z]{2,4})?$";

    private static final String MOBILE_REGEX = "^[0-9]{2}\\s[0-9]{10}$";

    public boolean isValidFirstName(String firstName) {
        return firstName != null && Pattern.matches(NAME_REGEX, firstName);
    }

    public boolean isValidLastName(String lastName) {
        return lastName != null && Pattern.matches(NAME_REGEX, lastName);
    }

    public boolean isValidEmail(String email) {
        return email != null && Pattern.matches(EMAIL_REGEX, email);
    }

    public boolean isValidMobile(String mobile) {
        return mobile != null && Pattern.matches(MOBILE_REGEX, mobile);
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        boolean hasMinimumEightCharacters = password.length() >= 8;
        boolean hasUpperCase = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasNumber = Pattern.compile("[0-9]").matcher(password).find();

        int specialCharacterCount = 0;

        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                specialCharacterCount++;
            }
        }

        boolean hasExactlyOneSpecialCharacter = specialCharacterCount == 1;

        return hasMinimumEightCharacters
                && hasUpperCase
                && hasNumber
                && hasExactlyOneSpecialCharacter;
    }

    public boolean validateFirstName(String firstName) throws InvalidUserDetailException {
        if (!isValidFirstName(firstName)) {
            throw new InvalidUserDetailException(
                    InvalidUserDetailException.ExceptionType.INVALID_FIRST_NAME,
                    "Invalid First Name");
        }
        return true;
    }

    public boolean validateLastName(String lastName) throws InvalidUserDetailException {
        if (!isValidLastName(lastName)) {
            throw new InvalidUserDetailException(
                    InvalidUserDetailException.ExceptionType.INVALID_LAST_NAME,
                    "Invalid Last Name");
        }
        return true;
    }

    public boolean validateEmail(String email) throws InvalidUserDetailException {
        if (!isValidEmail(email)) {
            throw new InvalidUserDetailException(
                    InvalidUserDetailException.ExceptionType.INVALID_EMAIL,
                    "Invalid Email");
        }
        return true;
    }

    public boolean validateMobile(String mobile) throws InvalidUserDetailException {
        if (!isValidMobile(mobile)) {
            throw new InvalidUserDetailException(
                    InvalidUserDetailException.ExceptionType.INVALID_MOBILE,
                    "Invalid Mobile Number");
        }
        return true;
    }

    public boolean validatePassword(String password) throws InvalidUserDetailException {
        if (!isValidPassword(password)) {
            throw new InvalidUserDetailException(
                    InvalidUserDetailException.ExceptionType.INVALID_PASSWORD,
                    "Invalid Password");
        }
        return true;
    }
}
