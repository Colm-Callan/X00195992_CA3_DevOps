## X00195992_CA3_DevOps

Small Spring Boot calculator project with Gradle build, JaCoCo coverage, Sonar analysis and an Azure Pipelines CI config.

## Requirements (local)

- Java 21
- Gradle wrapper

Tested with:
- Gradle 8.6
- Java 21


## Quick start — build & test (Windows PowerShell)

From the repository root

Stop any Gradle daemons and refresh dependencies:

.\gradlew.bat --stop and 
.\gradlew.bat --refresh-dependencies


Run the full verification (this runs unit tests, generates JaCoCo reports and enforces the coverage gate):

.\gradlew.bat :app:clean :app:test :app:jacocoTestReport :app:jacocoTestCoverageVerification --info

If you only want tests and the coverage report (skip the coverage gate):

.\gradlew.bat :app:clean :app:test :app:jacocoTestReport --info


If you need to skip the coverage verification task in a temporary run:

.\gradlew.bat :app:clean :app:test :app:jacocoTestReport -x :app:jacocoTestCoverageVerification --info


## Code coverage (JaCoCo)

- The project generates a JaCoCo XML at:
  app/build/reports/jacoco/test/jacocoTestReport.xml

- An HTML report is generated at:
  app/build/reports/jacoco/test/html/index.html


Coverage gate:
- The Gradle build enforces a coverage gate at 80% instruction coverage (`jacocoTestCoverageVerification`).
- This gate is currently hard-coded in `app/build.gradle` and is required for CI to pass. If current tests are below 80% the verification task will fail the build.


## SonarCloud

- Sonar plugin is configured in the project; the standard Sonar properties are read from system properties.


## Azure Pipelines

A azure-pipelines.yml is in the repository. 
Key points:
- Runs from repo root (so settings.gradle/pluginManagement is used).
- Uses the Gradle wrapper: gradlew.
- The Gradle step runs :app:clean :app:test :app:jacocoTestReport :app:jacocoTestCoverageVerification :app:sonar


## Adding tests to increase coverage

Tests:
- Unit tests



## Files of interest

- settings.gradle — pluginManagement and dependencyResolutionManagement
- app/build.gradle — build configuration, dependencies, JaCoCo and Sonar
- azure-pipelines.yml — CI pipeline configuration runs tests, coverage & Sonar.
- app/src/test/java — test files.
