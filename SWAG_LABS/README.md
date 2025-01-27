# Swag Labs Automation Testing Project

This project focuses on automating the testing of Swag Labs, an e-commerce application. The primary features covered include the login functionality, product handling, cart operations, and checkout processes. The framework is designed to ensure accuracy, maintainability, and scalability.

## Key Features

- **Framework**: TestNG with Page Object Model (POM).
- **Tools and Libraries**: Selenium WebDriver, Maven, TestNG Listeners.
- **Design Patterns**: Page Object Model for reusable and maintainable test scripts.
- **Configurable Setup**: Managed via constants for easy configuration.

## Framework Details

- **TestNG**: Used for test execution, grouping, and parallel testing, enabling efficient test management.
- **Page Object Model (POM)**: Provides a structured approach for UI interaction and script maintainability.
- **Selenium WebDriver**: Ensures robust browser automation and interaction with web elements.
- **Maven**: Streamlines dependency management and project builds for consistent execution.
- **TestNG Listeners**: Enables customized test reporting and logging for detailed insights.

## Highlights

- **Comprehensive Test Coverage**: Validates various login scenarios, product workflows, and checkout functionalities.
- **Scalable and Reusable Framework**: Facilitates the addition of new test cases with minimal changes.
- **Tracking Test Execution**: Uses TestNG Listeners to track the execution flow and test results.
- **Optimized Test Design**: Modular structure with reusable components for enhanced efficiency.

## Test Scenarios

### Login Functionality:
- Validates multiple login scenarios, including:
  - Valid credentials.
  - Invalid credentials.
  - Locked-out users.
  - Problem users.
  - Performance glitch users.

### Test Cases for E-Commerce Flow:
- **Fetching Product Details**: Verifies product details are correctly displayed.
- **Adding Products to the Cart**: Ensures products are added to the cart correctly.
- **Validating Cart Operations**: Tests cart operations, including adding, removing, and updating products.
- **Completing the Checkout Process**: Verifies successful order completion.
- **Verifying Error Messages During Checkout**: Ensures appropriate error messages are shown during the checkout process.