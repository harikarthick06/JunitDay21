package com.userregistration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("User Registration Validator Tests")
class UserValidatorTest {

    private UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
    }

    // UC1: First Name Validation
    @Nested
    @DisplayName("UC1: First Name Validation")
    class FirstNameValidationTests {

        @Test
        @DisplayName("Valid first name should return true")
        void testValidFirstName() {
            assertTrue(validator.isValidFirstName("Hari"));
            assertTrue(validator.isValidFirstName("John"));
            assertTrue(validator.isValidFirstName("Alexander"));
        }

        @Test
        @DisplayName("First name with lowercase starting letter should return false")
        void testFirstNameWithLowercaseStart() {
            assertFalse(validator.isValidFirstName("hari"));
        }

        @Test
        @DisplayName("First name with less than 3 characters should return false")
        void testFirstNameTooShort() {
            assertFalse(validator.isValidFirstName("Ha"));
            assertFalse(validator.isValidFirstName("J"));
        }

        @Test
        @DisplayName("Null first name should return false")
        void testNullFirstName() {
            assertFalse(validator.isValidFirstName(null));
        }

        @Test
        @DisplayName("First name with special characters should return false")
        void testFirstNameWithSpecialChars() {
            assertFalse(validator.isValidFirstName("Hari@"));
        }

        @Test
        @DisplayName("First name with numbers should return false")
        void testFirstNameWithNumbers() {
            assertFalse(validator.isValidFirstName("Hari123"));
        }

        @Test
        @DisplayName("validateFirstName should throw exception for invalid first name")
        void testValidateFirstNameThrowsException() {
            assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateFirstName("hari");
            });
        }

        @Test
        @DisplayName("validateFirstName should return true for valid first name")
        void testValidateFirstNameReturnsTrue() throws InvalidUserDetailException {
            assertTrue(validator.validateFirstName("Hari"));
        }
    }

    // UC2: Last Name Validation
    @Nested
    @DisplayName("UC2: Last Name Validation")
    class LastNameValidationTests {

        @Test
        @DisplayName("Valid last name should return true")
        void testValidLastName() {
            assertTrue(validator.isValidLastName("Karthick"));
            assertTrue(validator.isValidLastName("Smith"));
        }

        @Test
        @DisplayName("Last name with lowercase starting letter should return false")
        void testLastNameWithLowercaseStart() {
            assertFalse(validator.isValidLastName("karthick"));
        }

        @Test
        @DisplayName("Last name with less than 3 characters should return false")
        void testLastNameTooShort() {
            assertFalse(validator.isValidLastName("Ka"));
        }

        @Test
        @DisplayName("Null last name should return false")
        void testNullLastName() {
            assertFalse(validator.isValidLastName(null));
        }

        @Test
        @DisplayName("validateLastName should throw exception for invalid last name")
        void testValidateLastNameThrowsException() {
            assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateLastName("karthick");
            });
        }

        @Test
        @DisplayName("validateLastName should return true for valid last name")
        void testValidateLastNameReturnsTrue() throws InvalidUserDetailException {
            assertTrue(validator.validateLastName("Karthick"));
        }
    }

    // UC3: Email Validation
    @Nested
    @DisplayName("UC3: Email Validation")
    class EmailValidationTests {

        @Test
        @DisplayName("Valid email formats should return true")
        void testValidEmails() {
            assertTrue(validator.isValidEmail("abc@bl.co.in"));
            assertTrue(validator.isValidEmail("abc.xyz@bl.co.in"));
            assertTrue(validator.isValidEmail("abc+xyz@bl.co.in"));
            assertTrue(validator.isValidEmail("abc_xyz@bl.co.in"));
            assertTrue(validator.isValidEmail("abc-xyz@bl.co.in"));
        }

        @Test
        @DisplayName("Email without @ should return false")
        void testEmailWithoutAt() {
            assertFalse(validator.isValidEmail("abcblcoin"));
        }

        @Test
        @DisplayName("Email without domain extension should return false")
        void testEmailWithoutExtension() {
            assertFalse(validator.isValidEmail("abc@bl"));
        }

        @Test
        @DisplayName("Email without local part should return false")
        void testEmailWithoutLocalPart() {
            assertFalse(validator.isValidEmail("@bl.co.in"));
        }

        @Test
        @DisplayName("Null email should return false")
        void testNullEmail() {
            assertFalse(validator.isValidEmail(null));
        }

        @Test
        @DisplayName("validateEmail should throw exception for invalid email")
        void testValidateEmailThrowsException() {
            assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateEmail("abc@bl");
            });
        }

        @Test
        @DisplayName("validateEmail should return true for valid email")
        void testValidateEmailReturnsTrue() throws InvalidUserDetailException {
            assertTrue(validator.validateEmail("abc@bl.co.in"));
        }
    }

    // UC4: Mobile Validation
    @Nested
    @DisplayName("UC4: Mobile Validation")
    class MobileValidationTests {

        @Test
        @DisplayName("Valid mobile format (CC XXXXXXXXXX) should return true")
        void testValidMobile() {
            assertTrue(validator.isValidMobile("91 9919819801"));
            assertTrue(validator.isValidMobile("44 1234567890"));
        }

        @Test
        @DisplayName("Mobile without country code should return false")
        void testMobileWithoutCountryCode() {
            assertFalse(validator.isValidMobile("9919819801"));
        }

        @Test
        @DisplayName("Mobile with invalid format should return false")
        void testMobileWithInvalidFormat() {
            assertFalse(validator.isValidMobile("919919819801"));
        }

        @Test
        @DisplayName("Mobile with letters should return false")
        void testMobileWithLetters() {
            assertFalse(validator.isValidMobile("91 991981980a"));
        }

        @Test
        @DisplayName("Null mobile should return false")
        void testNullMobile() {
            assertFalse(validator.isValidMobile(null));
        }

        @Test
        @DisplayName("validateMobile should throw exception for invalid mobile")
        void testValidateMobileThrowsException() {
            assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateMobile("9919819801");
            });
        }

        @Test
        @DisplayName("validateMobile should return true for valid mobile")
        void testValidateMobileReturnsTrue() throws InvalidUserDetailException {
            assertTrue(validator.validateMobile("91 9919819801"));
        }
    }

    // UC5: Password Validation
    @Nested
    @DisplayName("UC5: Password Validation")
    class PasswordValidationTests {

        @Test
        @DisplayName("Valid password should return true")
        void testValidPassword() {
            assertTrue(validator.isValidPassword("Hari@123"));
            assertTrue(validator.isValidPassword("Password@1"));
        }

        @Test
        @DisplayName("Password with less than 8 characters should return false")
        void testPasswordTooShort() {
            assertFalse(validator.isValidPassword("Hari@1"));
        }

        @Test
        @DisplayName("Password without uppercase letter should return false")
        void testPasswordWithoutUppercase() {
            assertFalse(validator.isValidPassword("hari@123"));
        }

        @Test
        @DisplayName("Password without number should return false")
        void testPasswordWithoutNumber() {
            assertFalse(validator.isValidPassword("Hari@abc"));
        }

        @Test
        @DisplayName("Password without special character should return false")
        void testPasswordWithoutSpecialChar() {
            assertFalse(validator.isValidPassword("Hari1234"));
        }

        @Test
        @DisplayName("Password with more than one special character should return false")
        void testPasswordWithMultipleSpecialChars() {
            assertFalse(validator.isValidPassword("Hari@#123"));
        }

        @Test
        @DisplayName("Null password should return false")
        void testNullPassword() {
            assertFalse(validator.isValidPassword(null));
        }

        @Test
        @DisplayName("validatePassword should throw exception for invalid password")
        void testValidatePasswordThrowsException() {
            assertThrows(InvalidUserDetailException.class, () -> {
                validator.validatePassword("hari@123");
            });
        }

        @Test
        @DisplayName("validatePassword should return true for valid password")
        void testValidatePasswordReturnsTrue() throws InvalidUserDetailException {
            assertTrue(validator.validatePassword("Hari@123"));
        }
    }

    // UC6: Password Upper Case Validation
    @Nested
    @DisplayName("UC6: Password Must Have At Least 1 Upper Case")
    class PasswordUpperCaseTests {

        @Test
        @DisplayName("Happy test: Password with uppercase should be valid")
        void testPasswordWithUppercaseValid() {
            assertTrue(validator.isValidPassword("Hari@123"));
            assertTrue(validator.isValidPassword("HELLO@123"));
        }

        @Test
        @DisplayName("Sad test: Password without uppercase should be invalid")
        void testPasswordWithoutUppercaseSad() {
            assertFalse(validator.isValidPassword("hello@123"));
            assertFalse(validator.isValidPassword("test@1234"));
        }
    }

    // UC7: Password Numeric Number Validation
    @Nested
    @DisplayName("UC7: Password Must Have At Least 1 Numeric Number")
    class PasswordNumericTests {

        @Test
        @DisplayName("Happy test: Password with numeric should be valid")
        void testPasswordWithNumericValid() {
            assertTrue(validator.isValidPassword("Hari@123"));
            assertTrue(validator.isValidPassword("Test@1234"));
        }

        @Test
        @DisplayName("Sad test: Password without numeric should be invalid")
        void testPasswordWithoutNumericSad() {
            assertFalse(validator.isValidPassword("Hari@abc"));
            assertFalse(validator.isValidPassword("Test@abc"));
        }
    } // UC8: Password Special Character Validation

    @Nested
    @DisplayName("UC8: Password Must Have Exactly 1 Special Character")
    class PasswordSpecialCharacterTests {

        @Test
        @DisplayName("Happy test: Password with exactly 1 special char should be valid")
        void testPasswordWithOneSpecialCharValid() {
            assertTrue(validator.isValidPassword("Hari@123"));
            assertTrue(validator.isValidPassword("Test#1234"));
            assertTrue(validator.isValidPassword("Hello$1234"));
        }

        @Test
        @DisplayName("Sad test: Password without special char should be invalid")
        void testPasswordWithoutSpecialCharSad() {
            assertFalse(validator.isValidPassword("Hari1234"));
        }

        @Test
        @DisplayName("Sad test: Password with multiple special chars should be invalid")
        void testPasswordWithMultipleSpecialCharsSad() {
            assertFalse(validator.isValidPassword("Hari@#123"));
            assertFalse(validator.isValidPassword("Test@$1234"));
        }
    }

    // UC10: Parameterized Email Validation Tests
    @Nested
    @DisplayName("UC10: Parameterized Email Validation")
    class ParameterizedEmailTests {

        @Test
        @DisplayName("Happy test: Multiple valid email samples should pass")
        void testMultipleValidEmailSamples() {
            String[] validEmails = {
                    "abc@bl.co.in",
                    "abc.xyz@bl.co.in",
                    "abc+xyz@bl.co.in",
                    "abc_xyz@bl.co.in",
                    "abc-xyz@bl.co.in",
                    "a@bl.co.in",
                    "abc123@test.com"
            };

            for (String email : validEmails) {
                assertTrue(validator.isValidEmail(email), "Email " + email + " should be valid");
            }
        }

        @Test
        @DisplayName("Sad test: Multiple invalid email samples should fail")
        void testMultipleInvalidEmailSamples() {
            String[] invalidEmails = {
                    "abc",
                    "abc@",
                    "@bl.co.in",
                    "abc@bl",
                    "abc..xyz@bl.co.in",
                    "abc xyz@bl.co.in"
            };

            for (String email : invalidEmails) {
                assertFalse(validator.isValidEmail(email), "Email " + email + " should be invalid");
            }
        }
    }

    // UC11: Custom Exception Handling for All Fields
    @Nested
    @DisplayName("UC11: Custom Exception Handling")
    class CustomExceptionTests {

        @Test
        @DisplayName("Happy test: Valid entries should not throw exception")
        void testValidEntriesNoException() throws InvalidUserDetailException {
            // All should pass without throwing exceptions
            assertTrue(validator.validateFirstName("Hari"));
            assertTrue(validator.validateLastName("Karthick"));
            assertTrue(validator.validateEmail("abc@bl.co.in"));
            assertTrue(validator.validateMobile("91 9919819801"));
            assertTrue(validator.validatePassword("Hari@123"));
        }

        @Test
        @DisplayName("Sad test: Invalid first name should throw INVALID_FIRST_NAME exception")
        void testInvalidFirstNameException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateFirstName("hari");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_FIRST_NAME, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid last name should throw INVALID_LAST_NAME exception")
        void testInvalidLastNameException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateLastName("karthick");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_LAST_NAME, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid email should throw INVALID_EMAIL exception")
        void testInvalidEmailException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateEmail("abc@bl");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_EMAIL, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid mobile should throw INVALID_MOBILE exception")
        void testInvalidMobileException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateMobile("9919819801");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_MOBILE, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid password should throw INVALID_PASSWORD exception")
        void testInvalidPasswordException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validatePassword("hari@123");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid password (no uppercase) should throw exception with correct type")
        void testInvalidPasswordNoUppercaseException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validatePassword("hello@123");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid password (no number) should throw exception with correct type")
        void testInvalidPasswordNoNumberException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validatePassword("Hello@abc");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid password (no special char) should throw exception with correct type")
        void testInvalidPasswordNoSpecialCharException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validatePassword("Hello1234");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD, exception.getType());
        }

        @Test
        @DisplayName("Sad test: Invalid password (multiple special chars) should throw exception")
        void testInvalidPasswordMultipleSpecialCharsException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validatePassword("Hello@#1234");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD, exception.getType());
        }
    }

    // UC9: Email Samples Validation
    @Nested
    @DisplayName("UC9: Clear All Email Samples")
    class EmailSamplesTests {

        @Test
        @DisplayName("Happy test: Valid email samples should pass")
        void testValidEmailSamples() {
            // Valid email samples that should pass
            String[] validSamples = {
                    "abc@bl.co.in",
                    "abc.xyz@bl.co.in",
                    "abc+xyz@bl.co.in",
                    "abc_xyz@bl.co.in",
                    "abc-xyz@bl.co.in",
                    "a@bl.co.in",
                    "abc123@test.com",
                    "user@example.org",
                    "john.doe@company.co.uk",
                    "test123@domain.info"
            };

            for (String email : validSamples) {
                assertTrue(validator.isValidEmail(email),
                        "Valid email '" + email + "' should return true");
            }
        }

        @Test
        @DisplayName("Sad test: Invalid email samples should fail")
        void testInvalidEmailSamples() {
            // Invalid email samples that should fail
            String[] invalidSamples = {
                    "abc", // No @ symbol
                    "abc@", // No domain
                    "@bl.co.in", // No local part
                    "abc@bl", // No domain extension
                    "abc..xyz@bl.co.in", // Double dots
                    "abc xyz@bl.co.in", // Contains space
                    "abc@.co.in", // Invalid domain
                    "abc@bl..co.in", // Double dots in domain
                    "", // Empty string
                    "plainaddress", // No @ symbol
                    "abc@domain", // No TLD
                    "abc@@domain.com", // Double @ symbol
                    "abc@domain..com" // Double dots in extension
            };

            for (String email : invalidSamples) {
                assertFalse(validator.isValidEmail(email),
                        "Invalid email '" + email + "' should return false");
            }
        }

        @Test
        @DisplayName("Sad test: Edge case email samples should fail appropriately")
        void testEdgeCaseEmailSamples() {
            assertFalse(validator.isValidEmail(null), "Null email should return false");
            assertFalse(validator.isValidEmail(""), "Empty email should return false");
            assertFalse(validator.isValidEmail(" "), "Whitespace email should return false");
        }
    }

    // UC10: Parameterized Email Validation Tests
    @Nested
    @DisplayName("UC10: Parameterized Email Validation")
    class ParameterizedEmailValidationTests {

        @ParameterizedTest(name = "Email: {0}")
        @DisplayName("Happy test: Multiple valid emails should pass")
        @ValueSource(strings = {
                "abc@bl.co.in",
                "abc.xyz@bl.co.in",
                "abc+xyz@bl.co.in",
                "abc_xyz@bl.co.in",
                "abc-xyz@bl.co.in",
                "a@bl.co.in",
                "user@example.com",
                "john.doe@company.org",
                "test123@domain.co.uk",
                "info@test.net"
        })
        void testValidEmailsParameterized(String email) {
            assertTrue(validator.isValidEmail(email),
                    "Email '" + email + "' should be valid");
        }

        @ParameterizedTest(name = "Email: {0}")
        @DisplayName("Sad test: Multiple invalid emails should fail")
        @ValueSource(strings = {
                "abc",
                "abc@",
                "@bl.co.in",
                "abc@bl",
                "abc..xyz@bl.co.in",
                "abc xyz@bl.co.in",
                "plainaddress",
                "abc@@domain.com",
                "abc@domain..com",
                "test@.com"
        })
        void testInvalidEmailsParameterized(String email) {
            assertFalse(validator.isValidEmail(email),
                    "Email '" + email + "' should be invalid");
        }
    }

    // UC11: Custom Exception Handling - Refactored
    @Nested
    @DisplayName("UC11: Custom Exception Handling for Invalid Entries")
    class CustomExceptionHandlingTests {

        @Test
        @DisplayName("Happy test: Valid First Name should not throw exception")
        void testValidFirstNameNoException() throws InvalidUserDetailException {
            assertTrue(validator.validateFirstName("Hari"));
        }

        @Test
        @DisplayName("Happy test: Valid Last Name should not throw exception")
        void testValidLastNameNoException() throws InvalidUserDetailException {
            assertTrue(validator.validateLastName("Karthick"));
        }

        @Test
        @DisplayName("Happy test: Valid Email should not throw exception")
        void testValidEmailNoException() throws InvalidUserDetailException {
            assertTrue(validator.validateEmail("abc@bl.co.in"));
        }

        @Test
        @DisplayName("Happy test: Valid Mobile should not throw exception")
        void testValidMobileNoException() throws InvalidUserDetailException {
            assertTrue(validator.validateMobile("91 9919819801"));
        }

        @Test
        @DisplayName("Happy test: Valid Password should not throw exception")
        void testValidPasswordNoException() throws InvalidUserDetailException {
            assertTrue(validator.validatePassword("Hari@123"));
        }

        @Test
        @DisplayName("Sad test: Invalid First Name should throw INVALID_FIRST_NAME exception")
        void testInvalidFirstNameException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateFirstName("hari");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_FIRST_NAME, exception.getType());
            assertNotNull(exception.getMessage());
        }

        @Test
        @DisplayName("Sad test: Invalid Last Name should throw INVALID_LAST_NAME exception")
        void testInvalidLastNameException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateLastName("karthick");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_LAST_NAME, exception.getType());
            assertNotNull(exception.getMessage());
        }

        @Test
        @DisplayName("Sad test: Invalid Email should throw INVALID_EMAIL exception")
        void testInvalidEmailException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateEmail("abc@bl");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_EMAIL, exception.getType());
            assertNotNull(exception.getMessage());
        }

        @Test
        @DisplayName("Sad test: Invalid Mobile should throw INVALID_MOBILE exception")
        void testInvalidMobileException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validateMobile("9919819801");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_MOBILE, exception.getType());
            assertNotNull(exception.getMessage());
        }

        @Test
        @DisplayName("Sad test: Invalid Password should throw INVALID_PASSWORD exception")
        void testInvalidPasswordException() {
            InvalidUserDetailException exception = assertThrows(InvalidUserDetailException.class, () -> {
                validator.validatePassword("hari@123");
            });
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD, exception.getType());
            assertNotNull(exception.getMessage());
        }
    }

    // UC12: Refactored Custom Exception Handling - Extended Coverage
    @Nested
    @DisplayName("UC12: Extended Custom Exception Handling and Validation")
    class ExtendedCustomExceptionTests {

        @Test
        @DisplayName("Happy test: All valid entries should pass validation")
        void testAllValidEntriesPass() throws InvalidUserDetailException {
            assertTrue(validator.validateFirstName("John"));
            assertTrue(validator.validateLastName("Smith"));
            assertTrue(validator.validateEmail("john.smith@example.com"));
            assertTrue(validator.validateMobile("44 1234567890"));
            assertTrue(validator.validatePassword("Password@1"));
        }

        @Test
        @DisplayName("Sad test: Multiple invalid first names should throw exception with correct type")
        void testMultipleInvalidFirstNames() {
            String[] invalidFirstNames = { "hari", "john@", "Jo", "123", null };

            for (String name : invalidFirstNames) {
                if (name != null) {
                    InvalidUserDetailException exception = assertThrows(
                            InvalidUserDetailException.class,
                            () -> validator.validateFirstName(name));
                    assertEquals(InvalidUserDetailException.ExceptionType.INVALID_FIRST_NAME,
                            exception.getType());
                }
            }
        }

        @Test
        @DisplayName("Sad test: Multiple invalid last names should throw exception with correct type")
        void testMultipleInvalidLastNames() {
            String[] invalidLastNames = { "karthick", "smith@", "Jo", "123", null };

            for (String name : invalidLastNames) {
                if (name != null) {
                    InvalidUserDetailException exception = assertThrows(
                            InvalidUserDetailException.class,
                            () -> validator.validateLastName(name));
                    assertEquals(InvalidUserDetailException.ExceptionType.INVALID_LAST_NAME,
                            exception.getType());
                }
            }
        }

        @Test
        @DisplayName("Sad test: Multiple invalid emails should throw exception with correct type")
        void testMultipleInvalidEmails() {
            String[] invalidEmails = { "abc@bl", "abc@", "@bl.co.in", "abc", null };

            for (String email : invalidEmails) {
                if (email != null) {
                    InvalidUserDetailException exception = assertThrows(
                            InvalidUserDetailException.class,
                            () -> validator.validateEmail(email));
                    assertEquals(InvalidUserDetailException.ExceptionType.INVALID_EMAIL,
                            exception.getType());
                }
            }
        }

        @Test
        @DisplayName("Sad test: Multiple invalid mobiles should throw exception with correct type")
        void testMultipleInvalidMobiles() {
            String[] invalidMobiles = { "9919819801", "919919819801", "91-9919819801", "abc 1234567890", null };

            for (String mobile : invalidMobiles) {
                if (mobile != null) {
                    InvalidUserDetailException exception = assertThrows(
                            InvalidUserDetailException.class,
                            () -> validator.validateMobile(mobile));
                    assertEquals(InvalidUserDetailException.ExceptionType.INVALID_MOBILE,
                            exception.getType());
                }
            }
        }

        @Test
        @DisplayName("Sad test: Multiple invalid passwords should throw exception with correct type")
        void testMultipleInvalidPasswords() {
            String[] invalidPasswords = {
                    "hari@123", // No uppercase
                    "HELLO@123", // Valid but testing
                    "Hello@abc", // No number
                    "Hello1234", // No special char
                    "Hello@#1234", // Multiple special chars
                    "Hello@1", // Too short
                    null
            };

            for (String password : invalidPasswords) {
                if (password != null && !password.equals("HELLO@123")) {
                    InvalidUserDetailException exception = assertThrows(
                            InvalidUserDetailException.class,
                            () -> validator.validatePassword(password));
                    assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD,
                            exception.getType());
                }
            }
        }

        @Test
        @DisplayName("Comprehensive test: Exception type verification for all fields")
        void testExceptionTypeVerification() {
            // Test that each field throws its corresponding exception type
            InvalidUserDetailException fnException = assertThrows(
                    InvalidUserDetailException.class,
                    () -> validator.validateFirstName("invalid"));
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_FIRST_NAME, fnException.getType());

            InvalidUserDetailException lnException = assertThrows(
                    InvalidUserDetailException.class,
                    () -> validator.validateLastName("invalid"));
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_LAST_NAME, lnException.getType());

            InvalidUserDetailException emailException = assertThrows(
                    InvalidUserDetailException.class,
                    () -> validator.validateEmail("invalid"));
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_EMAIL, emailException.getType());

            InvalidUserDetailException mobileException = assertThrows(
                    InvalidUserDetailException.class,
                    () -> validator.validateMobile("invalid"));
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_MOBILE, mobileException.getType());

            InvalidUserDetailException passwordException = assertThrows(
                    InvalidUserDetailException.class,
                    () -> validator.validatePassword("invalid"));
            assertEquals(InvalidUserDetailException.ExceptionType.INVALID_PASSWORD, passwordException.getType());
        }
    }
}
