# Hybrid Automation Framework

## Overview

This project is a hybrid automation framework developed to support both UI and API automation using scalable architecture, reusable utilities, reporting integration, and CI/CD execution.

The framework was designed with maintainability, scalability, readability, and real-world automation practices in mind.

The project covers:

- UI Automation
- API Automation
- Cross-browser execution
- CRUD API validation
- Authentication testing
- Schema validation
- Response-time assertions
- Failure reporting with screenshots
- AI-based failure analysis
- CI/CD execution using GitHub Actions

---

# Tech Stack

- Java 17
- Selenium WebDriver
- TestNG
- Rest Assured
- Maven
- Apache POI
- Allure Reporting
- GitHub Actions

---

# Framework Architecture

## UI Automation Layer

The UI automation layer follows the Page Object Model (POM) design pattern.

### BaseTest
Responsible for:
- browser initialization
- setup and teardown
- common test flow handling

### DriverFactory
Handles:
- cross-browser execution
- ThreadLocal WebDriver management
- CI-compatible execution
- browser lifecycle management

### Page Classes
Contains:
- locators
- reusable UI actions
- page-specific validations

### Utilities
Framework utilities include:
- Excel reader
- screenshot utility
- config reader
- AI analyzer utility
- wait utilities
- reusable helpers

---

## API Automation Layer

The API framework is implemented using Rest Assured.

### API Coverage

Covered:
- CRUD operations
- authentication flows
- negative scenarios
- 4xx validation
- schema validation
- response-time assertions

### API Architecture

Implemented using:
- reusable service layer
- reusable request builder
- centralized config handling
- reusable validations

---

# Reporting Integration

The framework integrates Allure reporting to provide advanced execution visibility.

## Reporting Features

- pass/fail dashboard
- execution timeline
- screenshot attachment on failure
- stack trace visibility
- API execution logs
- AI-generated failure analysis

---

# AI-Based Failure Analysis

An AI-inspired failure analyzer utility was implemented to improve debugging visibility within reports.

The current implementation uses rule-based failure analysis to simulate intelligent debugging insights.

Examples:
- stale element handling suggestions
- no such element guidance
- timeout failure hints
- synchronization recommendations

This was added to demonstrate how AI assistance can improve automation debugging workflows.

If given more time, I would:
- integrate real OpenAI APIs
- add LLM-based root cause analysis
- generate intelligent debugging summaries
- implement flaky-test prediction
- implement automated fix recommendations

---
# Test Data Management

The framework uses Excel-driven testing to avoid hardcoded test data.

Used for:

positive login scenarios
negative login scenarios
reusable test inputs

Test Data Location:
test-data/

# Configuration Management
The framework uses centralized configuration management.

Managed through config files:

UI base URL
API base URL
browser configuration
credentials
environment data

Config Location:src/main/resources/config.properties

# CI/CD Integration

GitHub Actions was integrated to automate framework execution.

CI/CD Features
automatic execution on push
automatic execution on pull request
execution visibility
report artifact publishing
centralized execution monitoring

Pipeline File : .github/workflows/automation.yml
# Project Structure
project-root
│
├── .github
│   └── workflows
│       └── automation.yml
│
├── reports
│   └── screenshots
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── api
│   │   │   ├── base
│   │   │   ├── config
│   │   │   ├── pages
│   │   │   └── utils
│   │   │
│   │   └── resources
│   │
│   ├── test
│   │   ├── java
│   │   │   ├── api
│   │   │   ├── listeners
│   │   │   ├── retry
│   │   │   └── ui
│   │   │
│   │   └── resources
│
├── test-data
│
├── pom.xml
├── README.md
└── .gitignore

# Setup Instructions
Prerequisites

Install:

Java 17
Maven
Allure CLI

# API Test Coverage

# The API framework validates:

Create booking
Get booking
Update booking
Delete booking
Authentication validation
Error handling
Schema validation
Response-time validation
UI Test Coverage


# The UI framework validates:

successful login
invalid login
blank credential validation
dashboard validation
form validation
cross-browser smoke execution

# Generate Allure Report
allure serve target/allure-results

# Reporting Output

# The framework generates:

Allure dashboard
screenshots on failure
execution logs
AI analysis in failed scenarios

Sample screenshots are available under:

reports/screenshots/

# Design Decisions
# Why Page Object Model?

Used to improve:

maintainability
readability
reusability
# Why Config-Driven Framework?

To avoid hardcoded values and simplify environment management.

# Why ThreadLocal Driver?

To support:

thread safety
scalable browser execution
parallel execution readiness
# Why Allure?

Allure provides:

better visualization
execution insights
attachment support
cleaner reporting
# Why Excel-Driven Testing?

Used to:

avoid hardcoded test data
improve scalability
simplify test maintenance
Why AI Failure Analysis?

Added to demonstrate how AI-assisted debugging can improve automation troubleshooting and reporting visibility.

# Why GitHub Actions?

Used to automate:

framework execution
build validation
execution visibility
report publishing

# Current Limitations
Public demo websites may occasionally behave inconsistently
CI environments can introduce flaky browser behavior
Full UI/API integration testing was limited due to public website constraints
# Future Improvements

If given more time, I would:

optimize flaky test handling further
improve CI stability
integrate Docker execution
integrate Selenium Grid
add Slack notifications
add accessibility testing
add visual regression testing
integrate real AI APIs instead of static AI analysis
implement intelligent root-cause analysis
add distributed parallel execution
add database validation
improve reporting analytics
implement advanced flaky-test detectio
# Cross-Browser Support

The framework supports:
- Chrome
- Firefox

## Run on Chrome

```bash
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
