# java_saucedemo_demo

## Table of contents
- [Summary](#summary)
- [Technologies](#technologies)
- [Basic Architecture](#basic-architecture)
- [Executing tests](#executing-test)


## Summary
Test automation for an interview in FFW 

## Technologies
* java '18'
* Maven dependency manager 
* Selenium 4
* WebDriverManager 5
* Junit Jupiter 5
* JetBrains annotation 24

## Basic Architecture  
Pages Folder
The "Pages" folder is a directory where the page objects are located. 
A page object represents a specific web page or a logical unit of a web application. 
Each page object encapsulates the elements and actions associated with that particular page. 

BrowserFactory Folder
The "BrowserFactory" folder is a directory where instantiation of the browsers is implemented. 

Helpers Folder
The "Helpers" folder is a directory where custom waits of a web application are implemented.

Tests Folder 
The "Tests" folder is a dire ctory where tests are located in different classes each for a different type of user.

## Executing test
Place the caret at the test class to run all tests in that class,
or at the @test method, and press Ctrl + Shift + F10

