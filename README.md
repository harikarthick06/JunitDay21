# User Registration Problem - Complete UC Implementation (UC1-UC12)

This project implements a comprehensive user registration validation system with all 12 Use Cases implemented, tested, and validated with JUnit 5 and custom exception handling.

## 📋 Project Structure

```
src/
├── main/
│   └── java/com/userregistration/
│       ├── UserValidator.java                   # Main validation logic
│       ├── InvalidUserDetailException.java      # Custom exception
│       └── UserRegistrationApp.java            # Demo application
└── test/
    └── java/com/userregistration/
        └── UserValidatorTest.java              # 800+ lines with all UCs
```

## ✅ Completed Use Cases

### UC1: First Name Validation

- **Feature Branch**: `feature/UC1-FirstName`
- **Rules**: Starts with uppercase, minimum 3 chars, only letters
- **Tests**: 7 test cases (happy & sad)
- **Status**: ✅ COMPLETED & MERGED

### UC2: Last Name Validation

- **Feature Branch**: `feature/UC2-LastName`
- **Rules**: Starts with uppercase, minimum 3 chars, only letters
- **Tests**: 6 test cases (happy & sad)
- **Status**: ✅ COMPLETED & MERGED

### UC3: Email Validation

- **Feature Branch**: `feature/UC3-Email`
- **Rules**: Valid email format, supports special chars (. + - \_), domain extension required
- **Tests**: 7 test cases (happy & sad)
- **Status**: ✅ COMPLETED & MERGED

### UC4: Mobile Validation

- **Feature Branch**: `feature/UC4-Mobile`
- **Rules**: Format: CC (2 digits) + Space + Phone (10 digits)
- **Example**: "91 9919819801"
- **Tests**: 7 test cases (happy & sad)
- **Status**: ✅ COMPLETED & MERGED

### UC5: Password Validation - Basic Rules

- **Feature Branch**: `feature/UC5-Password`
- **Rules**: Min 8 chars, 1 uppercase, 1 digit, exactly 1 special char
- **Tests**: 8 test cases (happy & sad)
- **Status**: ✅ COMPLETED & MERGED

### UC6: Password Validation - Upper Case Rule

- **Rules**: Password must have at least 1 uppercase letter
- **Tests**: Happy & Sad test cases
- **Status**: ✅ COMPLETED & MERGED

### UC7: Password Validation - Numeric Rule

- **Rules**: Password must have at least 1 numeric digit
- **Tests**: Happy & Sad test cases
- **Status**: ✅ COMPLETED & MERGED

### UC8: Password Validation - Special Character Rule

- **Rules**: Password must have exactly 1 special character
- **Tests**: Happy & Sad test cases (no special char, multiple special chars)
- **Status**: ✅ COMPLETED & MERGED

### UC9: Email Samples Validation

- **Feature Branch**: `feature/UC9-EmailSamples`
- **Includes**:
  - 10 valid email samples
  - 13 invalid email samples
  - Edge cases (null, empty, whitespace)
- **Tests**: 3 comprehensive test methods
- **Status**: ✅ COMPLETED & MERGED

### UC10: Parameterized Email Validation Tests

- **Framework**: JUnit Jupiter @ParameterizedTest
- **Coverage**:
  - 10 valid emails (parameterized)
  - 10 invalid emails (parameterized)
- **Tests**: 20 parameterized test cases
- **Dependencies**: junit-jupiter-params
- **Status**: ✅ COMPLETED & MERGED

### UC11: Custom Exception Handling - Refactored

- **Exception Types**:
  - `INVALID_FIRST_NAME`
  - `INVALID_LAST_NAME`
  - `INVALID_EMAIL`
  - `INVALID_MOBILE`
  - `INVALID_PASSWORD`
- **Coverage**: Happy tests (no exception), Sad tests (throws correct exception type)
- **All Fields**: First Name, Last Name, Email, Mobile, Password
- **Status**: ✅ COMPLETED & MERGED

### UC12: Extended Custom Exception Handling

- **Validates**: All fields throw correct custom exceptions
- **Tests**:
  - Multiple invalid first names
  - Multiple invalid last names
  - Multiple invalid emails
  - Multiple invalid mobiles
  - Multiple invalid passwords
  - Exception type verification for all fields
- **Total Coverage**: 6 comprehensive test methods
- **Status**: ✅ COMPLETED & MERGED

---

## 🧪 Test Coverage Summary

| UC        | Test Cases | Type          | Status          |
| --------- | ---------- | ------------- | --------------- |
| UC1       | 7          | Unit          | ✅ PASS         |
| UC2       | 6          | Unit          | ✅ PASS         |
| UC3       | 7          | Unit          | ✅ PASS         |
| UC4       | 7          | Unit          | ✅ PASS         |
| UC5       | 8          | Unit          | ✅ PASS         |
| UC6       | 2          | Unit          | ✅ PASS         |
| UC7       | 2          | Unit          | ✅ PASS         |
| UC8       | 3          | Unit          | ✅ PASS         |
| UC9       | 3          | Integration   | ✅ PASS         |
| UC10      | 20         | Parameterized | ✅ PASS         |
| UC11      | 5          | Exception     | ✅ PASS         |
| UC12      | 6          | Exception     | ✅ PASS         |
| **TOTAL** | **76+**    | **Mixed**     | **✅ ALL PASS** |

---

## 🛠️ Build & Test

### Build the project

```bash
mvn clean build
```

### Run all tests

```bash
mvn test
```

### View test results

```bash
mvn test -Dtest=UserValidatorTest
```

### Run specific UC tests

```bash
mvn test -Dtest=UserValidatorTest$ParameterizedEmailValidationTests
```

---

## 📦 Dependencies

### Build Tools

- **Java**: 17+
- **Maven**: 3.8.9+

### Test Dependencies

- **JUnit Jupiter**: 5.10.0
- **JUnit Jupiter Params**: 5.10.0 (for parameterized tests)

### pom.xml Configuration

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

---

## 🔍 Validation Patterns

### Name Validation (UC1, UC2)

```regex
^[A-Z][a-zA-Z]{2,}$
```

- Starts with uppercase
- Followed by 2+ letters

### Email Validation (UC3, UC9, UC10)

```regex
^[a-zA-Z0-9]+([._+-][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\.[a-zA-Z]{2,4}(\.[a-zA-Z]{2,4})?$
```

- Alphanumeric with special chars (. + - \_)
- Requires @ and domain
- Supports multiple levels

### Mobile Validation (UC4)

```regex
^[0-9]{2}\s[0-9]{10}$
```

- 2-digit country code
- Space separator
- 10-digit phone number

### Password Validation (UC5-UC8)

Requirements:

- Minimum 8 characters
- At least 1 uppercase letter (UC6)
- At least 1 numeric digit (UC7)
- Exactly 1 special character (UC8)

---

## 🎯 Key Features

✅ **12 Complete Use Cases**
✅ **76+ Test Cases** (all passing)
✅ **Dual Validation APIs** (boolean & throwing methods)
✅ **Custom Exception Handling** (UC11, UC12)
✅ **Parameterized Tests** (UC10)
✅ **Email Sample Validation** (UC9)
✅ **Happy & Sad Test Cases** (all UCs)
✅ **Maven Integration**
✅ **JUnit 5 Framework**
✅ **Production Ready**

---

## 📊 Git Workflow

### Feature Branches

```
feature/UC1-FirstName
feature/UC2-LastName
feature/UC3-Email
feature/UC4-Mobile
feature/UC5-Password
feature/UC6-PasswordUpperCase (includes UC6-UC8)
feature/UC9-EmailSamples (includes UC9-UC12)
```

### Branch Strategy

- Each UC implemented in feature branch
- All features merged to `dev`
- `dev` merged to `main` for production
- All branches synced with GitHub

---

## 💾 Repository

**Repository**: harikarthick06/JunitDay21
**Current Status**: ✅ All UCs Implemented
**Branches**: main, dev, feature/\* (all synced)
**Commits**: 15+ (all documented)

---

## 🚀 API Reference

### UserValidator Methods

#### Boolean Validation Methods

```java
boolean isValidFirstName(String firstName)
boolean isValidLastName(String lastName)
boolean isValidEmail(String email)
boolean isValidMobile(String mobile)
boolean isValidPassword(String password)
```

#### Throwing Validation Methods

```java
boolean validateFirstName(String firstName) throws InvalidUserDetailException
boolean validateLastName(String lastName) throws InvalidUserDetailException
boolean validateEmail(String email) throws InvalidUserDetailException
boolean validateMobile(String mobile) throws InvalidUserDetailException
boolean validatePassword(String password) throws InvalidUserDetailException
```

---

## 📝 Example Usage

### Happy Test Case

```java
UserValidator validator = new UserValidator();

// Boolean method
if (validator.isValidEmail("john@example.com")) {
    System.out.println("Valid email");
}

// Throwing method
try {
    validator.validateFirstName("John");
    System.out.println("First name validated");
} catch (InvalidUserDetailException e) {
    System.out.println("Error: " + e.getMessage());
    System.out.println("Type: " + e.getType());
}
```

### Sad Test Case

```java
// Invalid input - boolean returns false
if (!validator.isValidPassword("weak")) {
    System.out.println("Password too weak");
}

// Invalid input - throws exception
try {
    validator.validateMobile("1234567890");
} catch (InvalidUserDetailException e) {
    // e.getType() == ExceptionType.INVALID_MOBILE
    System.out.println("Mobile format invalid");
}
```

---

## ✨ Project Status

### Completion Status: ✅ **100% COMPLETE**

- ✅ All 12 UCs implemented
- ✅ All tests passing (76+ cases)
- ✅ All branches synced to GitHub
- ✅ Custom exceptions refactored
- ✅ Parameterized tests added
- ✅ Email samples validated
- ✅ Documentation complete
- ✅ Production ready

---

## 📄 Files Modified/Created

- `UserValidator.java` - All validation logic
- `InvalidUserDetailException.java` - Custom exception with types
- `UserRegistrationApp.java` - Demo application
- `UserValidatorTest.java` - 800+ lines, all UCs
- `pom.xml` - Maven config with dependencies
- `README.md` - Complete documentation

---

## 🎓 Learning Outcomes

This project demonstrates:

- ✓ Unit testing with JUnit 5
- ✓ Parameterized testing
- ✓ Custom exceptions
- ✓ Regex validation
- ✓ Happy & Sad test cases
- ✓ Maven project structure
- ✓ Git workflow management
- ✓ Test-driven development

---

**Last Updated**: May 3, 2026
**Status**: ✅ PRODUCTION READY
**All Tests**: ✅ PASSING
