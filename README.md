# Aura Task

A sample project for automated API and UI testing using Java, Spring, Selenium, and RestAssured.

---

## 🚀 Features

- **API Testing:** REST API tests with Spring Boot and RestAssured
- **UI Testing:** End-to-end browser tests with Selenium WebDriver
- **Modern Java:** Uses Java 21, Lombok, and AssertJ for fluent assertions

---

## 🛠️ Getting Started

### Prerequisites

- Java 21+
- Maven 3.8+
- Chrome browser (for UI tests)

## 📁 Project Structure

| Folder                                         | Description                          |
|------------------------------------------------|--------------------------------------|
| `src/main/java/org/example/api`                | API client, DTOs, and helpers        |
| `src/main/java/org/example/ui`                 | UI page objects and elements         |
| `src/test/java/org/example`                    | Test scenarios and base test classes |
| `src/main/resources/application.properties`    | Test configuration                   |

---

## ⚙️ Configuration

- API base URI and UI app URL are set in `src/main/resources/application.properties`.
- Profiles (`api`, `ui`) are used to separate API and UI test contexts.

---

## 🧰 Technologies

- Spring Boot, Spring Test
- Selenium WebDriver
- RestAssured
- JUnit 5
- Lombok

---
