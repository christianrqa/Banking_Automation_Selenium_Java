# Banking Automation Selenium Java

A UI test automation framework for a banking web application built with **Selenium WebDriver, Java, TestNG, Maven, Page Object Model, Allure Reporting, JMeter, Git, and GitHub Actions**.

The project demonstrates a maintainable QA automation framework covering functional UI testing, test organization, reporting, performance testing, and continuous integration.

---

## Tech Stack

* **Java 25**
* **Selenium WebDriver 4.35.0**
* **TestNG 7.11.0**
* **Maven**
* **Page Object Model (POM)**
* **Allure Report**
* **Apache JMeter 5.6.3**
* **Git / GitHub**
* **GitHub Actions**
* **Chrome / ChromeDriver**

---

## Application Under Test

The automation framework currently targets the banking application available at:

`https://qaplayground.com/bank/login`

The automated UI coverage currently includes:

* Login
* Dashboard
* Accounts
* Transfers

---

## Framework Features

### UI Automation

The framework uses Selenium WebDriver with Java and follows the Page Object Model design pattern.

Implemented features include:

* Page Object Model
* Reusable base classes
* Explicit waits
* Centralized WebDriver creation
* Configuration through properties files
* Externalized test data
* TestNG annotations
* TestNG groups
* Smoke testing
* Regression testing
* Assertions
* CI-compatible headless Chrome execution

### Test Data

Test data is stored separately from the test classes using properties files.

Example:

```text
src/test/resources/testdata/login-data.properties
```

This keeps test data separate from test logic and makes test maintenance easier.

### Configuration

Application configuration is stored separately from the Java code.

Example:

```text
src/test/resources/config/config.properties
```

Current configuration includes:

* Application URL
* Browser selection

---

## Project Structure

```text
Banking_Automation_Selenium_Java/
|
+-- .github/
|   +-- workflows/
|       +-- ci.yml
|
+-- src/
|   +-- main/
|   |   +-- java/
|   |       +-- base/
|   |       +-- pages/
|   |       +-- utils/
|   |       +-- config/
|   |       +-- api/
|   |
|   +-- test/
|       +-- java/
|       |   +-- base/
|       |   +-- ui/
|       |   +-- api/
|       |
|       +-- resources/
|           +-- config/
|           +-- testdata/
|
|   +-- performance/
|       +-- banking-login-load-test.jmx
|       +-- README.md
|
+-- pom.xml
+-- testng.xml
+-- .gitignore
```

### Main Components

| Component            | Purpose                                                                  |
| -------------------- | ------------------------------------------------------------------------ |
| `base/`              | Reusable framework classes such as BasePage, BaseTest, and DriverFactory |
| `pages/`             | Page Object classes containing locators and page actions                 |
| `utils/`             | Reusable utilities such as configuration and test-data readers           |
| `config/`            | Configuration-related framework code                                     |
| `api/`               | Reserved for API automation expansion                                    |
| `ui/`                | UI test classes                                                          |
| `testdata/`          | External test data                                                       |
| `performance/`       | JMeter performance test plans                                            |
| `.github/workflows/` | GitHub Actions CI configuration                                          |

---

## Page Object Model

The framework separates page interactions from test scenarios.

For example:

```text
LoginTest
    |
    v
LoginPage
    |
    v
Selenium WebDriver
    |
    v
Banking Application
```

The Page Object classes contain:

* Locators
* Page interactions
* Page-specific verification methods

The test classes contain:

* Test scenarios
* Test data usage
* Assertions
* TestNG annotations

This separation makes the tests easier to maintain when the application UI changes.

---

## Test Coverage

The current functional UI automation includes:

### Login

Positive and negative login scenarios covering different user types and invalid credentials.

### Dashboard

Validation of the dashboard after successful authentication.

### Accounts

Validation of account-related information and functionality.

### Transfers

Functional transfer scenarios including:

* Account selection
* Transfer amount
* Memo
* Transfer date
* Review transfer
* Transfer confirmation
* Transfer cancellation
* Confirmation details

---

## TestNG Suites

The project uses TestNG groups to separate smoke and regression testing.

### Smoke Tests

The smoke suite focuses on critical application functionality.

Example command:

```bash
mvn test -Dgroups=smoke
```

### Regression Tests

The regression suite executes the broader automated functional coverage.

Example:

```bash
mvn test -Dgroups=regression
```

---

## Running the Tests

### Run the complete test suite

```bash
mvn test
```

### Run smoke tests

```bash
mvn test -Dgroups=smoke
```

### Run regression tests

```bash
mvn test -Dgroups=regression
```

The browser is configured through:

```text
src/test/resources/config/config.properties
```

Example:

```properties
base.url=https://qaplayground.com/bank/login
browser=chrome
```

---

## Test Reporting

The framework uses **Allure Report** for test reporting.

Allure provides a visual report containing information such as:

* Test results
* Test suites
* Features
* Behaviors
* Test status
* Severity
* Execution information

Allure metadata is added to the TestNG tests using annotations such as:

```java
@Epic
@Feature
@Severity
```

Allure results are generated under:

```text
target/allure-results
```

---

## Performance Testing

The project also includes a basic JMeter load test.

### Tool

Apache JMeter 5.6.3

### Scenario

Load testing of the banking application's login page.

### Current Configuration

* Virtual Users: 50
* Ramp-Up Period: 10 seconds
* Loop Count: 10
* Total Requests: 500

### Metrics

The test measures:

* Average response time
* Minimum response time
* Maximum response time
* Throughput
* Error percentage
* Number of requests

The JMeter test plan is located at:

```text
src/performance/banking-login-load-test.jmx
```

---

## Continuous Integration

GitHub Actions is configured to automatically execute the Maven test suite.

Workflow:

```text
Git Push
   |
   v
GitHub Actions
   |
   v
Checkout Repository
   |
   v
Set Up Java
   |
   v
Maven Test
   |
   v
TestNG
   |
   v
Selenium + Chrome
   |
   v
Test Results
```

The CI environment uses **headless Chrome** so Selenium can execute on the GitHub Actions Linux runner without a graphical display.

Local execution continues to use normal Chrome.

---

## GitHub Actions

The CI workflow is located at:

```text
.github/workflows/ci.yml
```

The workflow runs on:

* Pushes to `main`
* Pushes to `feature/framework-enhancements`
* Pull requests targeting `main`

---

## Current Status

The current framework has successfully demonstrated:

* Selenium UI automation
* Page Object Model
* TestNG
* Explicit waits
* Configuration management
* External test data
* Smoke testing
* Regression testing
* Allure reporting
* JMeter performance testing
* Git version control
* GitHub repository integration
* GitHub Actions CI
* Headless browser execution in CI

The local test suite and GitHub Actions pipeline are currently passing.

---

## Future Enhancements

Potential future improvements include:

* Expanded negative and validation scenarios
* Additional banking feature coverage
* REST API automation with REST Assured
* Database testing with SQL/JDBC
* Cross-browser execution
* Parallel test execution
* Improved CI test reporting
* Expanded performance testing
* Additional framework utilities

These items are planned enhancements and are not currently represented as completed functionality.

---

## Author
**Christian R. Reyes**

QA Automation / Software Quality Engineering

This project was created as a hands-on automation framework to develop practical experience with Selenium Java, TestNG, CI/CD, reporting, and performance testing.
