FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bankapp
COPY ./target/BankApp-Eurekaserver.jar /bankapp/BankApp-Eurekaserver.jar
EXPOSE 3333
ENTRYPOINT ["java","-jar","/bankapp/BankApp-Eurekaserver.jar"]