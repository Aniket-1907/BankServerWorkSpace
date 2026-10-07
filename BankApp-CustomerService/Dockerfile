FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bankapp
COPY ./target/BankApp-CustomerService.jar /bankapp/BankApp-CustomerService.jar
EXPOSE 4444
ENTRYPOINT ["java","-jar","/bankapp/BankApp-CustomerService.jar"]