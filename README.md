🧪 Truly Free Automation Framework

An End-to-End UI Automation Framework built using Java, Selenium WebDriver, TestNG, and Maven to automate the core user journey of the Truly Free E-commerce Website.
This framework follows the Page Object Model (POM) design pattern and integrates Extent Reports for detailed test reporting and screenshots for failure analysis.
🌐 Website Under Test
Main website automated in this project:
👉 https://trulyfree.com

The Truly Free platform provides eco-friendly and sustainable household products.
The automation simulates the complete customer purchase workflow.

🚀 Automated Test Scenarios

The automation framework covers the following test scenarios:

🔹 User Signup

Create new account

Dynamic mobile number generation

OTP verification

🔹 Brand Navigation

Hover over brands menu

Select alphabetically grouped brands

Navigate to brand product page

🔹 Product Selection

Select a product from brand catalog

🔹 Add Product to Cart

Add selected product to shopping cart

🔹 Cart Validation

Verify product is correctly added to cart

🔹 Checkout Process

Enter shipping details

Handle payment iframe fields

Place order successfully

⚙️ Framework & Tools Used
Tool	Purpose
Java	Programming language
Selenium WebDriver	Browser automation
TestNG	Test execution framework
Maven	Dependency management
Extent Reports	Advanced test reporting
Page Object Model (POM)	Framework design pattern
IntelliJ IDEA	IDE for development
📊 Extent Reports

The framework integrates Extent Reports to generate visually rich automation reports.

Features:

✔ Step-by-step test execution logs
✔ Pass / Fail / Skip test status
✔ Timestamped execution details
✔ Screenshot capture on failure

Report location:

test-output/ExtentReport.html

Example report:

Pass  ✔
Fail  ❌
Skipped ⚠
Execution Time ⏱
📸 Screenshot Capture

The framework automatically captures screenshots when a test fails.

Example folder:

test-output/screenshots/

Screenshots help in:

✔ Debugging failures
✔ Understanding UI issues
✔ Reporting bugs easily

🏗 Framework Design Pattern

This automation project follows the Page Object Model (POM) architecture.

Benefits:

✔ Clean code structure
✔ Separation of test logic and UI elements
✔ High maintainability
✔ Reusable components

📂 Project Folder Structure
truly-free-automation-task
│
├── src
│
│   ├── pages
│   │
│   │   SignupPage.java
│   │   BrandPage.java
│   │   ProductPage.java
│   │   CartPage.java
│   │   CheckoutPage.java
│   │   PaymentPage.java
│
│   ├── tests
│   │
│   │   SignupTest.java
│   │   BrandTest.java
│   │   ProductTest.java
│   │   CartTest.java
│   │   CheckoutTest.java
│
│   ├── utils
│   │
│   │   ScreenshotUtils.java
│   │   MobileGenerator.java
│
│   ├── reports
│   │
│   │   ExtentReportManager.java
│
│   └── pojo
│
│       SignupPojo.java
│       PlaceOrderPojo.java
│
├── pom.xml
└── README.md
⚡ Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/madhanqa08/truly-free-automation-task.git
2️⃣ Open Project

Open using:

IntelliJ IDEA
or
Eclipse
3️⃣ Install Dependencies

Maven will automatically download dependencies from:

pom.xml
▶️ How to Run the Tests
Option 1 — Using IntelliJ
Right Click → Test Class → Run
Option 2 — Using Maven

Run all tests using:

mvn test
🧠 Key Automation Concepts Used

Selenium WebDriver automation

Page Object Model (POM)

Explicit waits for synchronization

TestNG test management

Extent reporting

Screenshot capture on failures

Dynamic test data generation

Handling iframe based payment fields

📸 Test Flow
User Signup
      ↓
Brand Navigation
      ↓
Product Selection
      ↓
Add to Cart
      ↓
Cart Validation
      ↓
Checkout
      ↓
Payment
      ↓
Order Confirmation
👨‍💻 Author

Madhan Kumar B
QA Automation Engineer

GitHub:
https://github.com/madhanqa08
