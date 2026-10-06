FROM openjdk:17-alpine
WORKDIR /bankapp
COPY ./target/BankApp-Api-Gateway.jar /bankapp/BankApp-Api-Gateway.jar
EXPOSE 2222
ENTRYPOINT ["java","-jar","/bankapp/BankApp-Api-Gateway.jar"]