# Security Access Control System

A Java-based security access control system developed as a group coursework project for the Advanced Programming module.

The project explores role-based access control (RBAC), Java Generics, object-oriented programming, design patterns, JUnit testing, and access logging.

## Project Overview

The system is designed to manage access to resources according to user roles, permissions, and access policies.

It demonstrates how Java can be used to structure an access control application into separate components for users, resources, policies, capabilities, and logging.

## Key Features

- **Role-based access control:** Determines permissions based on user roles.
- **Generic capabilities:** Uses Java Generics to represent typed read and write capabilities.
- **Access policies:** Organises access-control rules into dedicated classes.
- **Access logging:** Includes components for recording access decisions.
- **JUnit testing:** Includes unit tests for validating system behaviour.

## Technologies Used

- Java 21
- Object-Oriented Programming (OOP)
- Java Generics
- JUnit 5
- Eclipse IDE

## Project Structure

```text
src/finalsystem/
├── app/          # Main application
├── capability/   # Generic capabilities
├── log/          # Access logging
├── model/        # Users, roles and resources
├── policy/       # Access-control policies
└── tests/        # JUnit tests
```

## Academic Project

Developed collaboratively as part of a six-member university group project for the Advanced Programming module.

This repository showcases the project's Java source code and its use of software engineering concepts.

## Example Output

The application demonstrates role-based access control by checking whether different users can perform operations on protected resources.

Examples include:

- **GUEST:** Can read lecture materials but cannot read exam papers.
- **STUDENT:** Can read the printer queue but cannot write to it.
- **STAFF:** Can read exam papers but cannot modify them.
- **ADMIN:** Can read and modify exam papers.

Each access attempt produces a timestamped log containing the user ID, role, resource, requested operation, and access decision (`ALLOW` or `REFUSE`).

## Running the Application

1. Install Java 21 or a compatible JDK.
2. Open the project in Eclipse.
3. Configure the project's Java build path if necessary.
4. Navigate to `src/finalsystem/app/FinalSystemRunner.java`.
5. Right-click the file and select **Run As → Java Application**.
6. View the access-control results in the Eclipse Console.

**Note:** JUnit 5 must also be configured separately to run the project's unit tests.

## Testing

The project includes automated unit tests using **JUnit 5**.

The tests exercise access-control decisions involving different user roles, resources, and operations.

**Test results:**
- Tests executed: 6
- Tests passed: 6
- Failures: 0
- Errors: 0

All six tests passed during local execution in Eclipse using JUnit 5.

### Running the Tests

1. Open the project in Eclipse.
2. Ensure JUnit 5 is configured in the project's build path.
3. Navigate to `src/finalsystem/tests/Finalsystemtest.java`.
4. Right-click the file and select **Run As → JUnit Test**.
5. View the results in Eclipse's JUnit panel.
