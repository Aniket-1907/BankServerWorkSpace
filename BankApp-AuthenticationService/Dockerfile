FROM openjdk:17-alpine
WORKDIR /bankapp
COPY ./target/BankApp-AuthenticationService.jar /bankapp/BankApp-AuthenticationService.jar
EXPOSE 9012
ENTRYPOINT ["java","-jar","/bankapp/BankApp-AuthenticationService.jar"]