FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=build/libs/calculator-gradle-0.1.0.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]