# Appium Android Automation Portfolio Project

This is a sample mobile automation framework created for my QA Automation portfolio.

The goal of this project is to demonstrate practical knowledge of:

- Java
- Maven
- Appium
- Selenium WebDriver concepts
- TestNG
- Android automation
- Page Object Model
- GitLab CI/CD project validation
- Clean project structure for recruiters and hiring managers

---

## Project Structure

```text
appium-android-automation/
├── apps/
│   └── ApiDemos-debug.apk
├── src/
│   └── test/
│       ├── java/
│       │   └── com/portfolio/appium/
│       │       ├── base/
│       │       ├── pages/
│       │       ├── tests/
│       │       └── utils/
│       └── resources/
│           ├── config.properties
│           └── testng.xml
├── .gitlab-ci.yml
├── pom.xml
└── README.md
```

---

## Technology Stack

| Tool | Purpose |
|---|---|
| Java | Programming language |
| Maven | Build and dependency management |
| Appium | Mobile automation |
| TestNG | Test execution framework |
| Android Emulator / Real Device | Test execution environment |
| GitLab CI/CD | Project validation pipeline |

---

## Test Scenario

The sample test automates the Android ApiDemos app.

Test flow:

1. Launch ApiDemos app
2. Open `Views`
3. Open `Controls`
4. Open `1. Light Theme`
5. Enter text into a field
6. Tap checkbox
7. Tap radio button
8. Validate entered text

---

## Prerequisites

Install the following before running the tests:

1. Java JDK 17
2. Maven
3. Node.js
4. Appium
5. Android Studio or Android SDK
6. Android Emulator or real Android device
7. Git
8. Notepad++ or any text editor

---

## Install Appium

Open Command Prompt or PowerShell and run:

```bash
npm install -g appium
```

Install the Android UiAutomator2 driver:

```bash
appium driver install uiautomator2
```

Check Appium installation:

```bash
appium --version
```

---

## Add Demo Android App

This project uses the Android ApiDemos sample application.

Create this file location:

```text
apps/ApiDemos-debug.apk
```

You can download the ApiDemos APK from the official Appium sample-code repository.

Example search term:

```text
Appium ApiDemos-debug.apk GitHub sample-code
```

After downloading it, place the APK here:

```text
appium-android-automation/apps/ApiDemos-debug.apk
```

---

## Start Android Emulator

Open Android Studio and start an Android emulator.

Or connect a real Android phone with USB debugging enabled.

Check that the device is detected:

```bash
adb devices
```

Expected result example:

```text
List of devices attached
emulator-5554   device
```

---

## Start Appium Server

Open a new Command Prompt or PowerShell window and run:

```bash
appium
```

The Appium server should start on:

```text
http://127.0.0.1:4723
```

Keep this window open while running tests.

---

## Run Tests

Open another Command Prompt or PowerShell window from the project folder:

```bash
cd appium-android-automation
```

Run the tests:

```bash
mvn clean test
```

---

## Run Only Project Validation

If you only want to check whether the Java code compiles:

```bash
mvn clean test-compile
```

---

## Configuration

Configuration is stored in:

```text
src/test/resources/config.properties
```

Default values:

```properties
appium.server.url=http://127.0.0.1:4723
platform.name=Android
automation.name=UiAutomator2
device.name=Android Emulator
app.path=apps/ApiDemos-debug.apk
```

---

## GitLab CI/CD

The GitLab pipeline validates that the Maven project compiles successfully.

Pipeline file:

```text
.gitlab-ci.yml
```

The pipeline runs:

```bash
mvn clean test-compile
```

Mobile tests are not executed in GitLab CI by default because Appium tests require an Android emulator or real device.

---

## Screenshots on Failure

If a test fails, the framework saves a screenshot in:

```text
screenshots/
```

---

## Skills Demonstrated

This project demonstrates:

- Mobile automation framework setup
- Appium driver configuration
- Android UiAutomator2 automation
- TestNG test structure
- Page Object Model design
- Maven dependency management
- Test configuration management
- Screenshot capture on failure
- GitLab CI/CD validation
- Clean README documentation

---

## Author

Created by Piriyanga Christopher as part of a QA Automation portfolio.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
