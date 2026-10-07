FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bankapp
COPY ./target/BankApp-AccountService.jar /bankapp/BankApp-AccountService.jar
EXPOSE 7777
ENTRYPOINT ["java","-jar","/bankapp/BankApp-AccountService.jar"]