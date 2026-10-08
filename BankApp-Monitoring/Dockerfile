# =========================
# Build stage
# =========================
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /bankapp

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


# =========================
# Runtime stage
# =========================

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bankapp
COPY ./target/BankApp-Monitoring.jar /bankapp/BankApp-Monitoring.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/bankapp/BankApp-Monitoring.jar"]