FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bankapp
COPY ./target/BankApp-EurekaServer.jar /bankapp/BankApp-EurekaServer.jar
EXPOSE 3333
ENTRYPOINT ["java","-jar","/bankapp/BankApp-EurekaServer.jar"]