# x00195992_CA2

# Colm Callan Simple calculator app
Colm Callan X00195992

# Overview

This is my project that is a simple Java/Gradle calculator app. This app is to show what I have learned about Continuous Integration (CI) and its practices on Azure Pipelines

My calculators has basic maths features including addition, subtraction, multiplication and division.

The focus on this project was to ensure that all the features were tested and the code had enough code coverage (minimum 80%)
additionally I made sure to keep up with good repo commits and ensured to use multiple branches


# Technologies used

1. Java: for my code
2. gradle: for automating builds
3. JaCoCo: for test reports and coverage
4. Azure: for my pipeline
5. Github: for my repo

# local development setup

1. clone repo from github

2. checkout to the development branch
    (git checkout development)

3. gradle build and test
    (run from main directory)
    ./gradlew build
    ./gradlew test

4. to run the app
    ./gradlew run


# App Features
- add: add 2 numbers
- subtract: subtract 2 numbers
- multiply: multiply 2 numbers
- division: divide 2 numbers, throw an error if second number is 0

# CI pipeline implementation
(azure-pipelines.yml)
it is trigger on the main and development branches
gradle builds and runs tests
JaCoCo to enforce 80% coverage
Sonar posts results on their web page (couldnt get the azure extension to work)

this pipeline is trigger on any commit or PR to either main or dev branches making sure all new code passes tests and coverage before merging

# Branch policy & protection

main is the branch that is actually pushed out to users
development is the branch where the devs work on to push code before it is merged to main
other branches may be checked out by devs to work on new features/problems before being pushed to dev

protection:
currently requires pr before merging (+ 1 approval)
requires status checks pass before merging as well

(screenshots\BranchSecurity.png)

# Testing stragegy
- Unit tests: 
unit tests are implemented for all methods this ensures:
results are same as expected results and to make sure methods are working as intened

JaCoCo:
this ensures that all code is covered by a test
this also ensures devs dont rush their work as they will also have to test their work

Tests passed: screenshots\TestsPassed.png

Coverage report: screenshots\CoverageReport.png

# troubleshooting

if the pipeline doesnt run make sure you are 
using main or dev
the yaml file exists
github is not down

if gradlew doesnt work
make sure you are in the correct directory
sometimes I found I needed a clean run to fix issues

# References

The DevOps Brightspace slides

The DevOps Labs - https://github.com/TUDublin-Git/DOCID-Labs/tree/main

The 2 azure extra learning certificates via Microsoft Learn

##

in one terminal
& .\gradlew.bat -p app bootRun

in different term
& .\gradlew.bat -p app test --tests "*CalculatorSeleniumRunningAppTest" --info