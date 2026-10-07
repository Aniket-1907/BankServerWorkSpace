FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bankapp
COPY ./target/BankApp-Monitoring.jar /bankapp/BankApp-Monitoring.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/bankapp/BankApp-Monitoring.jar"]