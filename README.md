
# 📱 TUI Mobile Automation Framework

## 🧾 Overview

This is a mobile automation testing framework developed for the **TUI Challenge App** using:
- **Java 17**
- **Appium**
- **Cucumber (BDD)**
- **TestNG**
- **Maven**
- **Logback for logging**
- **Page Object Model (POM)** design pattern

---

## 📂 Project Structure

```
TUI/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── hooks/                 → Cucumber hooks (`SetupHook.java`)
│   │   │   ├── pages/                 → Page Object files
│   │   │   ├── reuseable/             → Data readers and reusable test data (`LoginData`, `Readers`)
│   │   │   └── utils/                 → Utility classes like `BaseTest`, `RetryAnalyzer`, `ScrollActions`, `ConfigManager`
│   │   └── resources/
│   │       ├── features/             → Cucumber feature files (`login.feature`)
│   │       └── config.properties     → App-specific configuration
│
│   ├── test/
│   │   ├── java/
│   │   │   ├── runners/              → Test runner file (`TestRunner.java`)
│   │   │   └── stepdefinitions/     → Step definitions for feature steps
│   └── resources/
│       └── testdata.json            → Test data in JSON format
│
├── logback.xml                      → Logback logging configuration
├── testng.xml                       → TestNG suite file (if used for execution)
├── pom.xml                          → Maven configuration
└── README.md                        → Project documentation
```

---

## 🔧 Prerequisites

- **Java JDK 17**
- **Maven** installed and configured in system path
- **Appium** installed:  
  ```bash
  npm install -g appium
  ```
- **Android Emulator** or **Real Device** connected
- Environment variable `ANDROID_HOME` set

---

## ▶️ How to Execute Tests

### 🌐 Option 1: Run from Command Line

**Start Appium Server** (in a separate terminal):
```bash
appium
```

**Execute using Maven:**
```bash
mvn clean test
```

**To run specific feature:**
```bash
mvn test -Dcucumber.features="src/main/resources/features/login.feature"
```

---

## 📦 Reporting & Logs

- **Logs:** Generated in `/logs/test-execution.log`
- **Logback** is configured in `logback.xml` for console and file output
- **Cucumber Reports:** View online report after execution:
  ```
  https://reports.cucumber.io/reports/<report-id>
  ```

---

## 🔁 Retry Logic

Retry mechanism is implemented using:
- `RetryAnalyzer.java`
- `RetryListener.java`
- Registered via `IAnnotationTransformer`

Failed tests are retried automatically to ensure test reliability.

---

## ✅ Sample Feature (BDD Style)

```gherkin
Feature: Login to TUI App

  @TUIHotels @Login
  Scenario: User logs into the app with valid credentials
    Given user launch the application
    When user logs into the app with valid credentials

  @TUIHotels @Dashboard
  Scenario: User on Dashboard Page
    Then user lands on dashboard page
    And user close the application
```

---

## Technologies Used

| Tool        | Purpose                          |
|-------------|----------------------------------|
| Java 17     | Programming language             |
| Appium      | Mobile automation engine         |
| Maven       | Build and dependency management  |
| Cucumber    | BDD and test steps               |
| TestNG      | Test execution framework         |
| Logback     | Logging framework                |

---

**Naveen D**  
Sr. Automation QA | Mobile | Web | API 
📧 naveenchris77@gmail.com  
📎 GitHub:(https://github.com/NaveenDuraisaamy)

---
