# WebAutomationDemo
Use Java, TestNG, and Selenium to do Web automation test for http://store.demoqa.com/.

# Specification
1. Support Windows, Linux(32, 64), and Mac system;
2. Support Chrome, Firefox, IE, and HtmlUnit browser;
3. PageObjects Design Pattern

# How to run the test cases?
1. Use IntelliJ to open pom.xml;
2. Right click "testng_*.xml" such as "testng_chrome.xml" and select "Run";

# Issue found
1. In `testVerifyMyDetails` method, some fields' response are invalid, such as "firstName", "lastName", "phone", "postCode";

# Potential Problems of This Project
1. Sometimes, `testAddIPhone4s2MyCart` and `testRemoveFromMyCart` may be failure because don't use "wait until", and need to improve in the future.
