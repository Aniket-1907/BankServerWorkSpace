FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bankapp
COPY ./target/BankApp-TransactionService.jar /bankapp/BankApp-TransactionService.jar
EXPOSE 5555
ENTRYPOINT ["java","-jar","/bankapp/BankApp-TransactionService.jar"]