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
COPY ./target/BankApp-Api-Gateway.jar /bankapp/BankApp-Api-Gateway.jar
EXPOSE 2222
ENTRYPOINT ["java","-jar","/bankapp/BankApp-Api-Gateway.jar"]