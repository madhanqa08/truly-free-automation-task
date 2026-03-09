# Truly Free Automation Task

## 📌 Project Overview

**Truly Free Automation Task** is a Selenium-based UI automation testing project developed using **Java, Selenium WebDriver, TestNG, and Extent Reports**.

The project automates core user workflows of the Truly Free website including **signup, login, and account-related actions**.  
It follows a **modular automation framework structure** to maintain scalability, readability, and maintainability.

The framework includes:

* Structured **test modules**
* **Reusable utilities**
* **Page Object Model design**
* **Extent Reports for test reporting**
* **Automatic screenshot capture for failures**

---

# 🧰 Framework & Technologies Used

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test execution framework |
| Maven | Dependency management |
| Extent Reports | Test reporting |
| WebDriverManager | Driver management |
| Page Object Model (POM) | Design pattern for maintainable automation |

---

# 🎥 Video Demonstration

A full demonstration video showing:

- Project structure
- Automation execution
- Generated reports

YouTube Video:

https://www.youtube.com/watch?v=YRux9GFwWBU

Google Drive Backup:

https://drive.google.com/file/d/1tK_1DK7tQEj8ixHaD6R3RUmxxi7RGGca/view?usp=sharing

---

# 📊 Live Automation Report

The Extent Report generated during automation execution is hosted here:

https://thriving-zuccutto-be0e0d.netlify.app/

This report includes:

- Test execution summary
- Pass / Fail status
- Execution timeline
- Screenshots for failed tests

---

# 📂 Project Structure (Fully Mapped)

```
truly-free-automation-task
│
├── reports
│   └── screenshorts
│       └── index.html
├── src
│   │
│   ├── main
│   │   └── java
│   │       └── pages
│   │       |   ├── BrandPage.java
│   │       |   ├── CartPage.java
│   │       |   ├── CheckoutPage.java
│   │       |   ├── LandingPage.java
│   │       |   ├── OrderPage.java
│   │       |   ├── PaymentPage.java
│   │       |   └── ProductPage.java
│   │       └── resources
│   │           └── ExtendedReport.java
│   │
│   └── test
│       └── java
│           │
│           ├── tests
│           │   └── EndtoEndFlowTest.java
│           │
│           ├── testcomponents
│           │   └── Baseclass.java
│           │   └── Listeners.java
│           │
│           ├── utilities
│           │   └── EmailGeneration.java
│           │   └── MobileGeneration.java
│           │
│           └── pojofiles
│               └── PlaceholderPojo.java
│               └── SiginPojo.java
│               └── OrderPojo.java
│               └── ProductPojo.java
│
├── resources
│   └── Globaldata.properties
│
├── pom.xml
│
├── testngxml
│
└── README.md
```

---

# 🖼 Report Screenshot

Below is a screenshot of the generated Extent Report.

![Extent Report Screenshot](https://github.com/madhanqa08/truly-free-automation-task/blob/9174d7f7e794d005484456b5d95d466a7144d7de/TrulyFreeHomeRecord.png)

---

# 🏗 Framework Architecture

The framework follows a **layered architecture**:

```
Test Layer
   ↓
Page Object Layer
   ↓
Utility Layer
   ↓
WebDriver Layer
```

### Layers Explanation

**Test Layer**

* Contains all TestNG test classes
* Responsible for executing test scenarios

**Page Object Layer**

* Contains page classes representing UI pages
* Stores locators and page actions

**Utility Layer**

Reusable helper classes for:

* Screenshot capture
* Random test data generation
* Explicit waits
* Driver initialization

**Reporting Layer**

* Extent Reports generate a **detailed HTML test report**
* Screenshots are attached automatically on failure

---

# 🚀 Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/madhanqa08/truly-free-automation-task.git
```

---

### 2️⃣ Open the Project

Open the project in:

```
IntelliJ IDEA
OR
Eclipse
```

---

### 3️⃣ Install Dependencies

Run Maven to install required dependencies:

```bash
mvn clean install
```

Dependencies include:

* Selenium
* TestNG
* WebDriverManager
* Extent Reports(Aventstack)
* commons-io

---

# ▶️ How to Run the Automation

### Method 1 — Run using TestNG XML

Execute:

```
testng.xml
```

in your IDE.

---

### Method 2 — Run using Maven

```bash
mvn test
```

---

# 📊 Test Reports

After execution, Extent Reports are generated at:

```
test-output/extent-report.html
```

The report includes:

* Test execution summary
* Passed / Failed tests
* Execution time
* Screenshot on failure

---

# 📸 Screenshots

Screenshots are automatically captured for failed test cases and stored in:

```
reports/screenshots/
```

This helps in debugging failures quickly.

---

# 🌐 Application Under Test

Main website homepage used for automation:

```
https://trulyfreehome.com
```

Automated workflows include:

* User Signup
* User Login
* Form validation
* Navigation verification
* UI interaction

---

# 🧪 Test Coverage

The automation suite covers the following areas:

* User Registration
* Login functionality
* Field validation
* UI navigation
* Error message verification

---

# 🔮 Future Improvements

Planned improvements for the framework:

* CI/CD integration using GitHub Actions
* Cross-browser testing
* Docker test execution
* Parallel execution
* Data-driven testing

---

# 🧠 Automation Approach

The automation solution was designed using a **Page Object Model (POM) based framework** to ensure clean separation between test logic and page interactions.

The following approach was used while developing the automation:

1. Website exploration to understand user workflows  
2. Identification of stable locators using browser developer tools  
3. Designing a modular framework structure using Page Object Model  
4. Implementing automated test scenarios using TestNG  
5. Creating reusable utility classes for test data generation and screenshots  
6. Integrating Extent Reports for detailed test execution reporting

This approach improves **maintainability, scalability, and readability of the automation framework**.

---

# 📄 Solution Summary Report

This automation project validates key user workflows on the **Truly Free website** using Selenium automation.

The primary objective of the solution is to:

- Automate important user journeys
- Verify UI interactions and navigation
- Validate form inputs and workflows
- Generate execution reports for analysis

Key features of the solution include:

- Modular Page Object Model framework
- Structured TestNG execution
- WebDriverManager for automatic driver handling
- Extent Reports integration
- Screenshot capture on test failures

The framework is designed to be **scalable and extendable**, allowing additional automation scenarios to be easily added.
---
---
# 👨‍💻 Author

**Madhan Kumar B**

Automation Test Engineer  
Java | Selenium | TestNG | Automation Framework Development

GitHub:  
https://github.com/madhanqa08

---
