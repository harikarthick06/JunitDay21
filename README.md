# User Registration Problem - UC Implementation

This project implements a comprehensive user registration validation system with support for First Name, Last Name, Email, Mobile Number, and Password validation.

## Project Structure

```
src/
├── main/
│   └── java/com/userregistration/
│       ├── UserValidator.java                   # Main validation logic
│       ├── InvalidUserDetailException.java      # Custom exception
│       └── UserRegistrationApp.java            # Demo application
└── test/
    └── java/com/userregistration/
        └── UserValidatorTest.java              # Comprehensive test suite
```

## Use Cases (UCs)

### UC1: First Name Validation
- **Branch**: `feature/UC1-FirstName`
- **Requirements**:
  - First name must start with an uppercase letter
  - Minimum 3 characters long
  - Only alphabetic characters allowed
- **Status**: ✅ Completed and merged to dev/main

### UC2: Last Name Validation
- **Branch**: `feature/UC2-LastName`
- **Requirements**:
  - Last name must start with an uppercase letter
  - Minimum 3 characters long
  - Only alphabetic characters allowed
- **Status**: ✅ Completed and merged to dev/main

### UC3: Email Validation
- **Branch**: `feature/UC3-Email`
- **Requirements**:
  - Valid email format
  - Can contain alphanumeric characters, dots (.), plus (+), hyphens (-), and underscores (_)
  - Must have @ symbol and domain extension
  - Supports multiple domain levels (e.g., bl.co.in)
- **Status**: ✅ Completed and merged to dev/main

### UC4: Mobile Validation
- **Branch**: `feature/UC4-Mobile`
- **Requirements**:
  - Format: Country Code (2 digits) + Space + Phone Number (10 digits)
  - Example: "91 9919819801"
  - Only numeric characters (plus space as separator)
- **Status**: ✅ Completed and merged to dev/main

### UC5: Password Validation
- **Branch**: `feature/UC5-Password`
- **Requirements**:
  - Minimum 8 characters
  - At least one uppercase letter
  - At least one numeric digit
  - Exactly one special character
- **Status**: ✅ Completed and merged to dev/main

## Build & Test

### Build the project
```bash
mvn clean build
```

### Run tests
```bash
mvn test
```

### Run the demo application
```bash
mvn exec:java -Dexec.mainClass="com.userregistration.UserRegistrationApp"
```

## API Documentation

### UserValidator Class

#### Boolean Validation Methods (return boolean)
```java
boolean isValidFirstName(String firstName)
boolean isValidLastName(String lastName)
boolean isValidEmail(String email)
boolean isValidMobile(String mobile)
boolean isValidPassword(String password)
```

#### Throwing Validation Methods (throw InvalidUserDetailException)
```java
boolean validateFirstName(String firstName) throws InvalidUserDetailException
boolean validateLastName(String lastName) throws InvalidUserDetailException
boolean validateEmail(String email) throws InvalidUserDetailException
boolean validateMobile(String mobile) throws InvalidUserDetailException
boolean validatePassword(String password) throws InvalidUserDetailException
```

## Test Coverage

Comprehensive test suite with 40+ test cases covering:
- Valid inputs
- Invalid inputs
- Null inputs
- Edge cases
- Exception handling

### Test Categories
- **FirstNameValidationTests**: 7 test cases
- **LastNameValidationTests**: 6 test cases
- **EmailValidationTests**: 7 test cases
- **MobileValidationTests**: 7 test cases
- **PasswordValidationTests**: 8 test cases

All tests: ✅ PASSING

## Git Workflow

The project follows a structured Git workflow:

### Branch Structure
- `main` - Production/stable branch (contains all UCs)
- `dev` - Development branch (contains all UCs)
- `feature/UC1-FirstName` - UC1 feature branch
- `feature/UC2-LastName` - UC2 feature branch
- `feature/UC3-Email` - UC3 feature branch
- `feature/UC4-Mobile` - UC4 feature branch
- `feature/UC5-Password` - UC5 feature branch

### Merge Strategy
Each UC was implemented as follows:
1. Create feature branch from `dev`
2. Implement UC with tests and demo code
3. Ensure all tests pass
4. Push feature branch to GitHub
5. Merge feature branch back to `dev`
6. Push `dev` to GitHub
7. After all UCs complete, merge `dev` to `main`

## Dependencies

- **Java**: 17+
- **Maven**: 3.8.9+
- **JUnit**: 5.10.0 (for testing)

## Validation Regex Patterns

### Name Validation (First Name & Last Name)
```regex
^[A-Z][a-zA-Z]{2,}$
```

### Email Validation
```regex
^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\.[a-zA-Z]{2,4}(\.[a-zA-Z]{2,4})?$
```

### Mobile Validation
```regex
^[0-9]{2}\s[0-9]{10}$
```

## Exception Handling

### InvalidUserDetailException
Custom exception with exception types:
- `INVALID_FIRST_NAME`
- `INVALID_LAST_NAME`
- `INVALID_EMAIL`
- `INVALID_MOBILE`
- `INVALID_PASSWORD`

## Example Usage

```java
UserValidator validator = new UserValidator();

// Using boolean methods
if (validator.isValidFirstName("John")) {
    System.out.println("Valid first name");
}

// Using throwing methods
try {
    validator.validateEmail("john@example.com");
    System.out.println("Email validated successfully");
} catch (InvalidUserDetailException e) {
    System.out.println("Validation failed: " + e.getMessage());
    InvalidUserDetailException.ExceptionType type = e.getType();
}
```

## Project Completion Status

✅ **All UCs Complete**
- UC1: First Name Validation - COMPLETED
- UC2: Last Name Validation - COMPLETED
- UC3: Email Validation - COMPLETED
- UC4: Mobile Validation - COMPLETED
- UC5: Password Validation - COMPLETED

All code merged to both `dev` and `main` branches with passing tests.
