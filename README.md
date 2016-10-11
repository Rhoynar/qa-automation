# QA Automation Project 

This projects provides an example bare-bones project using BDD/Cucumber, Java, TestNG, WebDriver, Page Objects and Maven. The motivation for providing this setup is to help QA Automation engineers with an initial framework they can begin their automation work from.

This project comes fully integrated with Selenium WebDriver, Behavior Driven Development using Cucumber semantics, Java, TestNG and Maven. All the dependencies are included in pom.xml and the end-user can clone this repository and begin immediately on BDD development by using:

```
mvn clean test
```


The project already contains sample test files which can be edited and modified according to user needs.

---

## WebApp Framework
The project contains a java class for Web application management - this could include browser management, login/logout management, cookie management, loading databases etc. I usually treat WebApp as the framework from which I can create other Page Objects that allow me to do specific page object functionalities.

## Utilities - ExcelUtils, DateTime, ReadProperties
A bunch of utilities which are commonly used in day-to-day QA operations and are pretty much useful to all QA projects. I like to include them along with our core libraries to avoid repeated efforts to generate these on their own.

## Feature Files, Step Defs and Page Objects
All BDD specs are written in Cucumber .feature files. These are present under resources/features directory. All step-definitions are written under com.rhoynar.qa.steps package. All Page objects are under com.rhoynar.qa.pages package.

---

# Contact Us
Feel free to contact us if you have further questions or need any help in designing and architecting your QA framework. Our team at [Rhoynar](http://www.rhoynar.com) specializes in QA Automation engineering using latest technologies. You may also reach us at [contact@rhoynar.com](contact@rhoynar.com).

